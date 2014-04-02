/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationcoefficientanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author 陳仲詠
 */
public class dictionaryGenerator 
{
    public static ArrayList<String> dictionaryGenerator(String filepath) throws FileNotFoundException, IOException
    {
        ArrayList<String> List=new ArrayList<String>();
        FileReader ListFile=new FileReader(filepath);
        BufferedReader bufList=new BufferedReader(ListFile);
        for(String str=bufList.readLine();str!=null;str=bufList.readLine())
        {
            StringTokenizer strToken=new StringTokenizer(str);
            while(strToken.hasMoreTokens())
            {
                List.add(strToken.nextToken());
            }
        }
        return List;
    }
    
}
