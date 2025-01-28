import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[][] arr;
    static List<CCTV> cctvs = new ArrayList<>();
    static int blindSpot = Integer.MAX_VALUE;

    // 상, 하, 좌, 우
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    cctvs.add(new CCTV(i, j, arr[i][j]));
                }
            }
        }
        dfs(0);

        System.out.println(blindSpot);
    }

    static void dfs(int cctvCount) {
        if (cctvCount == cctvs.size()) {
            int tempBlindSpot = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (arr[i][j] == 0) {
                        tempBlindSpot++;
                    }
                }
            }
            blindSpot = Math.min(blindSpot, tempBlindSpot);
            return;
        }

        CCTV cctv = cctvs.get(cctvCount);
        int x = cctv.x;
        int y = cctv.y;
        int type = cctv.type;

        for (int[] directionsSet : getDirections(type)) {
            int[][] backup = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    backup[i][j] = arr[i][j];
                }
            }

            for (int dir : directionsSet) {
                int nx = x;
                int ny = y;

                while (true) {
                    nx += directions[dir][0];
                    ny += directions[dir][1];

                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 6) {
                        break;
                    }
                    if (arr[nx][ny] == 0) {
                        arr[nx][ny] = -1;
                    }
                }
            }

            dfs((cctvCount + 1));

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    arr[i][j] = backup[i][j];
                }
            }
        }
    }

    //감시 가능한 방향 조합
    static List<int[]> getDirections(int type) {
        List<int[]> directionsList = new ArrayList<>();
        switch (type) {
            case 1: // 한 방향
                for (int i = 0; i < 4; i++) {
                    directionsList.add(new int[]{i});
                }
                break;
            case 2: // 서로 반대
                directionsList.add(new int[]{0, 1});
                directionsList.add(new int[]{2, 3});
                break;
            case 3: // 직각
                directionsList.add(new int[]{0, 3}); // 상, 우
                directionsList.add(new int[]{3, 1}); // 우, 하
                directionsList.add(new int[]{1, 2}); // 하, 좌
                directionsList.add(new int[]{2, 0}); // 좌, 상
                break;
            case 4: // 세 방향
                directionsList.add(new int[]{0, 2, 3}); // 상, 좌, 우
                directionsList.add(new int[]{0, 1, 3}); // 상, 하, 우
                directionsList.add(new int[]{1, 2, 3}); // 하, 좌, 우
                directionsList.add(new int[]{0, 1, 2}); // 상, 하, 좌
                break;
            case 5: // 네 방향
                directionsList.add(new int[]{0, 1, 2, 3}); // 상, 하, 좌, 우
                break;
        }
        return directionsList;
    }


    static class CCTV {
        int x, y, type;

        public CCTV(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}