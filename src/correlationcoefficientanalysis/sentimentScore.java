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
public class sentimentScore 
{
    public static int[] sentimentScore(int documentno,ArrayList<String> positiveList,ArrayList<String> negativeList, int weight, int topic) throws FileNotFoundException, IOException
    {
        int sentimentScore[]=new int[documentno];
        for(int i=0;i<documentno;i++)
        {
            String str=autoSelectTopicName.autoSelectTopicName(topic);
            FileReader document=new FileReader("dataset\\"+str+"\\"+(i+1)+".txt");
            BufferedReader br=new BufferedReader(document);
            ArrayList<String> docuToken=new ArrayList<String>();
            int positive=0;
            int negative=0;
            for(String str1=br.readLine();str1!=null;str1=br.readLine())
            {
                StringTokenizer token=new StringTokenizer(str1);
                while(token.hasMoreTokens())
                {
                    docuToken.add(token.nextToken().replaceAll("[‧￠′'“’(){}|+*~:;`_?,.@%$!#\"]"," ").toLowerCase());
                }
            }
            for(int j=0;j<docuToken.size();j++)
            {
                if(positiveList.contains(docuToken.get(j)))
                {
                    positive++;
                }
            }
             for(int j=0;j<docuToken.size();j++)
            {
                if(negativeList.contains(docuToken.get(j)))
                {
                    negative++;
                }
            }
            sentimentScore[i]=(positive-negative)*weight;
        }
        return sentimentScore;
    }
    
}
