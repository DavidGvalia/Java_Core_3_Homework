import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("/Users/davidgvaliya/Game"),
                new File("/Users/davidgvaliya/Game/src"),
                new File("/Users/davidgvaliya/Game/res"),
                new File("/Users/davidgvaliya/Game/savegames"),
                new File("/Users/davidgvaliya/Game/temp"),
                new File("/Users/davidgvaliya/Game/src/main"),
                new File("/Users/davidgvaliya/Game/src/test"),
                new File("/Users/davidgvaliya/Game/res/drawables"),
                new File("/Users/davidgvaliya/Game/res/vectors"),
                new File("/Users/davidgvaliya/Game/res/icons")
        );

        List<File> fileList = Arrays.asList(
                new File("/Users/davidgvaliya/Game/src/Main.java"),
                new File("/Users/davidgvaliya/Game/src/Utils.java"),
                new File("/Users/davidgvaliya/Game/temp/temp.txt")
        );

        folderList.stream()
                .forEach(folder -> {
                    if (folder.mkdir()){
                        sb.append("Папка " + folder + " создана\n");
                    } else
                        sb.append("Папка " + folder + " не создана\n");
                });


        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage());
            }
        });
        try (FileWriter log = new FileWriter("/Users/davidgvaliya/Game/temp/temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/davidgvaliya/Game/temp/temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
