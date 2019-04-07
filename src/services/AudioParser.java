package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AudioParser
{
    public static Metadata getMusicData(String fileLocation)
    {
        try
        {
            InputStream input = new FileInputStream(new File(fileLocation));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

//            System.out.println("----------------------------------------------");
//            System.out.println("Title: " + metadata.get("title"));
//            System.out.println("Artists: " + metadata.get("xmpDM:artist"));
//            System.out.println("Composer : "+metadata.get("xmpDM:composer"));
//            System.out.println("Genre : "+metadata.get("xmpDM:genre"));
//            System.out.println("Album : "+metadata.get("xmpDM:album"));

            return metadata;
        }
        catch (FileNotFoundException e){e.printStackTrace();}
        catch (IOException e){e.printStackTrace();}
        catch (SAXException e){e.printStackTrace();}
        catch (TikaException e){e.printStackTrace();}
        return null;
    }

    public static Map<String, Metadata> getMusicDataMap(Map <String, List<String>> folderFilesMap)
    {
        Map<String, Metadata> musicDataMap = new HashMap<>();

        for(String folder : folderFilesMap.keySet())
        {
            for (String file : folderFilesMap.get(folder))
            {
                musicDataMap.put(folder + "/" + file,AudioParser.getMusicData("src/musiques/" + folder + "/" + file));
            }
        }
        return musicDataMap;
    }

}