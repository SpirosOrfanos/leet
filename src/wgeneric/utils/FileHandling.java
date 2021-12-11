package wgeneric.utils;


import java.nio.charset.StandardCharsets;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHandling {
    public static void main(String... args) throws IOException {
        String fn = "CRDB20211202.csv";
        String currentDir = System.getProperty("user.dir").concat(File.separator);
        System.out.println(currentDir.concat("CRDB20211202.csv"));
        File f = new File(currentDir+fn);
        FileHandling app = new FileHandling();
        String fileName = "Prefix_"+fn;
        Path folder = Paths.get(currentDir);
        Path file = Files.createTempFile(folder, fileName,".csv");
        InputStream io = (app.stripBy(f, ','));
        Files.copy(io, file, StandardCopyOption.REPLACE_EXISTING);
        Path path = Paths.get(currentDir.concat("CRDB20211202.csv"));
        System.out.println(path.toAbsolutePath());
        io = (app.stripBy(f, ','));
        Stream<String> lines = Files.lines(path);
        String text = new BufferedReader(
                new InputStreamReader(io, StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));
    System.out.println(text);
        Files.write(path, text.getBytes());
        lines.close();


        /*String fileName = "Prefix_"+fn;
        InputStream input = new FileInputStream(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String strLine;
        String pre = null;
        int count = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        long lines = br.lines().count();
        input = new FileInputStream(f);
        br = new BufferedReader(new InputStreamReader(input));
        while ((strLine = br.readLine()) != null)   {
            if (count == 0) {
                bos.write(rem(strLine).getBytes("UTF-8"));
            } else if(lines >1){
                bos.write(strLine.concat("\r\n").getBytes("UTF-8"));
            } else {
                bos.write(rem(strLine).getBytes("UTF-8"));
            }
            lines --;
            count++;
        }
        //bos.write(rem(pre).getBytes("UTF-8"));
        //System.out.println(bos.toString());
        Path folder = Paths.get(currentDir);
        Path file = Files.createTempFile(folder, fileName,".csv");

        Files.copy(new ByteArrayInputStream(bos.toByteArray()), file, StandardCopyOption.REPLACE_EXISTING);
     //   Files.copy(folder, bos);
        input.close();
        bos.close();*/
    }


    private InputStream stripBy(File f, char stripBy) {
        ByteArrayOutputStream bos = null;
        InputStream input = null;
        BufferedReader br = null;
        try {
            String strLine;
            int count = 0;
            bos = new ByteArrayOutputStream();
            input = new FileInputStream(f);
            br = new BufferedReader(new InputStreamReader(input));
            long lines = br.lines().count();
            input = new FileInputStream(f);
            br = new BufferedReader(new InputStreamReader(input));
            while ((strLine = br.readLine()) != null)   {
                if (count == 0) {
                    bos.write(rem(strLine, stripBy).getBytes("UTF-8"));
                } else if(lines >1){
                    bos.write(strLine.concat("\r\n").getBytes("UTF-8"));
                } else {
                    bos.write(rem(strLine, stripBy).getBytes("UTF-8"));
                }
                lines --;
                count++;
            }
            input.close();
            bos.close();
            br.close();
            return new ByteArrayInputStream(bos.toByteArray());
        } catch (Exception e) {

        }
        return null;
    }
    private String rem(String value, char stripBy) {
        char[] vChar = value.toCharArray();
        for (int i = vChar.length-1; i>=0; i--) {
            if(vChar[i] != stripBy) break;
            vChar[i] = '\u0000';
        }
        return String.valueOf(vChar).trim().concat("\r\n");
    }
}
