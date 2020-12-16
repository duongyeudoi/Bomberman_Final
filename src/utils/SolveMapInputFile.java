package utils;

public class SolveMapInputFile {
    private String fileData;
    public int Width;
    public int Height;
    public int[][] mapp = new int[100][100];

    public SolveMapInputFile(String fileData) {
        this.fileData = fileData;

        // Tach Width va Height
        int e = 0;
        while (e < fileData.length() && fileData.charAt(e) != ' ') {
            ++ e;
        }
        ++ e;
        int height = 0;
        int width = 0;
        while (e < fileData.length() && fileData.charAt(e) != ' ') {
            height = 10 * height + (int) fileData.charAt(e) - '0';
            ++ e;
        }
        this.Height = height;
        ++ e;
        while (e < fileData.length() && fileData.charAt(e) != '\n') {
            width = 10 * width + (int) fileData.charAt(e) - '0';
            ++ e;
        }
        this.Width = width;

        // Doc map
        ++ e;
        for (int i = 0; i < height; ++ i) {
            for (int j = 0; j < width; ++ j ) {
                switch (fileData.charAt(e)) {
                    case '#' :
                        // Wall
                        mapp[i][j] = 1;
                        break;
                    case '*' :
                        //Brick
                        mapp[i][j] = 2;
                        break;
                    case 'x':
                        //PortalItem
                        mapp[i][j] = 0;
                        break;
                    case 'p':
                        // BombItem - Boomer
                        mapp[i][j] = 0;
                        break;
                    case '1':
                        //FlameItem - Balloom
                        mapp[i][j] = 69;
                        break;
                    case '2':
                        //Oneal
                        mapp[i][j] = 96;
                        break;
                    case 'b':
                        //BombITEM
                        mapp[i][j] = 7;
                        break;
                    case 'f':
                        //FLAME_ITEM
                        mapp[i][j] = 8;
                        break;
                    case's':
                        //SPEED_ITEM
                        mapp[i][j] = 9;
                        break;
                    default:
                        mapp[i][j] = 0;
                }
                if (j == this.Width - 1) {
                    e += 2;
                } else {
                    ++ e;
                }
            }
        }
    }
}
