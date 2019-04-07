package test;

import org.apache.tika.metadata.Metadata;
import services.AudioParser;
import services.FileParser;

import java.util.*;

public class TestParser
{
    public static Metadata testAudioParser(String musicFile)
    {
//        String musicFile = "src/musiques/alter_bridge-blackbird/01-Ties-That-Bind.mp3";
        return AudioParser.getMusicData(musicFile);
    }

    public static void testFileParser()
    {
        String folderPath = "src/musiques/alter_bridge-blackbird";
        FileParser.getListOfFiles(folderPath);
    }

    public static List<Metadata> testParser()
    {
        String folderPath = "src/musiques/alter_bridge-blackbird";
        List<String> listFilePath = FileParser.getListOfFiles(folderPath);
        List<Metadata> listMetadata = new ArrayList<>();
        for (String filePath : listFilePath)
        {
            listMetadata.add(AudioParser.getMusicData(folderPath + "/" + filePath));
        }

        //System.out.println(listMetadata);
        return listMetadata;
    }

    public static void recuperationAlbums()
    {
        List<Metadata> listMetadata = testParser();
        for (Metadata metadata : listMetadata)
        {
            if(metadata.get("title") != null)
            {
                System.out.println("----------------------------------------------");
                System.out.println("Title: " + metadata.get("title"));
                System.out.println("Artists: " + metadata.get("xmpDM:artist"));
//                System.out.println("Composer : " + metadata.get("xmpDM:composer"));
                System.out.println("Genre : " + metadata.get("xmpDM:genre"));
                System.out.println("Album : " + metadata.get("xmpDM:album"));
            }
        }
    }
}
