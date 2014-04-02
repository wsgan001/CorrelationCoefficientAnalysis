/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationcoefficientanalysis;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author 陳仲詠
 */
public class CorrelationCoefficientAnalysis {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException 
    {
        for(int topic=9;topic<=12;topic++)
        {
            // TODO code application logic here
            String str=autoSelectTopicName.autoSelectTopicName(topic);
            System.out.println("============="+str+"=====================");
            String  filePath = "dataset70\\"+str+"\\frequency.txt";
            String solution = "dataset70\\"+str+"\\solu.txt";
            int namequantity = VectorReader.getnamequantity(filePath);
            int documentquantity = VectorReader.getdocumentquantity(filePath);
            double namevector[][] = new double[namequantity][documentquantity];
            namevector = VectorReader.vectorReader(filePath);
            //計算相關係數
            double cor[][] = new double[namequantity][namequantity];
            cor = correlationCoefficient.correlationCoefficient(namevector, namequantity, documentquantity);
            int weight=1;//給予positive, negative的權重
            ArrayList<String> positiveList=new ArrayList<String>();
            ArrayList<String> negativeList=new ArrayList<String>();
            if(topic==1||topic==2||topic==3||topic==4)
            {
                positiveList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\sportPositiveList.txt");
                negativeList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\sportNegativeList.txt");
            }
            if(topic==5||topic==6||topic==7||topic==8)
            {
                positiveList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\businessPositiveList.txt");
                negativeList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\businessNegativeList.txt");
            }
            if(topic==9||topic==10||topic==11||topic==12)
            {
                positiveList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\politicPositiveList.txt");
                negativeList=dictionaryGenerator.dictionaryGenerator("posNegWordList(1v)\\politicNegativeList.txt");
            }
        
            int score[]=new int[documentquantity];
            score=sentimentScore.sentimentScore(documentquantity, positiveList, negativeList, weight, topic);
            double ratio[][][]=new double[namequantity][namequantity][4];
            ratio=sentimentRatio.sentitmentRatio(namequantity, documentquantity, score, namevector);
            //計算兩人相關細數
            /*
            for(int i=0;i<documentquantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    System.out.print(namevector[j][i]+" ");
                }
                System.out.println();
            }
            for(int i=0;i<documentquantity;i++)
            {
                System.out.println(score[i]+" ");
            }
            System.out.println();
            */
            //相關係數
            for(int i=0;i<namequantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    System.out.print(cor[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            //positive ratio-negative ratio
            System.out.println("===只看document正負的比例差===");
            for(int i=0;i<namequantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    System.out.print((ratio[i][j][0]-ratio[i][j][1])+" ");
                }
                System.out.println();
            }
            System.out.println("===考量正負字量的比例差===");
            for(int i=0;i<namequantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    System.out.print((ratio[i][j][2]-ratio[i][j][3])+" ");
                }
                System.out.println();
            }
            /*
            double AllCount[]=sentimentRatio.sentitmentRatioForAverage(namequantity, documentquantity, score, namevector);
            System.out.println("===看大於document出現平均數後正負的比例差(沒有權重)===");
            for(int i=0;i<namequantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    if(ratio[i][j][0]>AllCount[0]&&ratio[i][j][1]<AllCount[1])
                    System.out.print((ratio[i][j][0]-ratio[i][j][1])+" ");
                        
                }
                System.out.println();
            }
            System.out.println("===看大於document出現平均數後正負的比例差(有權重)===");
            for(int i=0;i<namequantity;i++)
            {
                for(int j=0;j<namequantity;j++)
                {
                    if(ratio[i][j][2]>AllCount[2]&&ratio[i][j][3]<AllCount[3])
                    System.out.print((ratio[i][j][2]-ratio[i][j][3])+" ");
                }
                System.out.println();
            }
            */
        }
    }
}
