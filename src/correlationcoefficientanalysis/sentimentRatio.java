/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationcoefficientanalysis;

/**
 *
 * @author 陳仲詠
 */
public class sentimentRatio 
{
    public static double[][][] sentitmentRatio(int namequantity, int documentquantity, int score[], double namevector[][])
    {
        //計算如果兩人相關係數為正，positive document的量與negative document的量
        double positiveCount[][][]=new double[namequantity][namequantity][2];
        double negativeCount[][][]=new double[namequantity][namequantity][2];
        double ratio[][][]=new double[namequantity][namequantity][8];//0,1 是存沒有權重的document positive,negative, 2,3 是存有權重的, 
        for(int i=0;i<namequantity;i++)
        {
            for(int j=0;j<namequantity;j++)
            {
                double cooccurrence=0;
                for(int k=0;k<documentquantity;k++)
                {
                    if(namevector[i][k]>0&&namevector[j][k]>0)//代表都有出現
                    {
                        cooccurrence++;
                        if(score[k]>=0)
                        {   
                            positiveCount[i][j][0]++;
                        }else
                        {
                            negativeCount[i][j][0]++;
                        }
                    }
                }
                if(cooccurrence>0)
                {
                    ratio[i][j][0]=(double)positiveCount[i][j][0]/cooccurrence;
                    ratio[i][j][1]=(double)negativeCount[i][j][0]/cooccurrence;
                }else
                {
                    ratio[i][j][0]=0;
                    ratio[i][j][1]=0;
                }
                //加入權重的計算
                cooccurrence=0;
                for(int k=0;k<documentquantity;k++)
                {
                    if(namevector[i][k]>0&&namevector[j][k]>0)//代表都有出現
                    {
                        cooccurrence++;
                        if(score[k]>=0)
                        {   
                            positiveCount[i][j][1]+=score[k];
                        }else
                        {
                            negativeCount[i][j][1]+=score[k];
                        }
                    }
                }
                if(cooccurrence>0)
                {
                    ratio[i][j][2]=(double)positiveCount[i][j][1]/cooccurrence;
                    ratio[i][j][3]=(double)negativeCount[i][j][1]/cooccurrence;
                }else
                {
                    ratio[i][j][2]=0;
                    ratio[i][j][3]=0;
                }
            }
        }
        return ratio;
    }
    public static double[] sentitmentRatioForAverage(int namequantity, int documentquantity, int score[], double namevector[][])
    {
        //計算所有document與 name pair的positive, negative加總
        double AllCount[]=new double[4];//0,1(positive, negative)沒有權重, 2,3 有權重
        double all=0;
        for(int i=0;i<namequantity;i++)
        {
            for(int j=0;j<namequantity;j++)
            {
                for(int k=0;k<documentquantity;k++)
                {
                    if(namevector[i][k]>0&&namevector[j][k]>0)//代表都有出現
                    {
                        all++;
                        if(score[k]>=0)
                        {   
                            AllCount[0]++;
                        }else
                        {
                            AllCount[1]++;
                        }
                    }
                }
                //加入權重的計算
                for(int k=0;k<documentquantity;k++)
                {
                    if(namevector[i][k]>0&&namevector[j][k]>0)//代表都有出現
                    {
                        if(score[k]>=0)
                        {   
                            AllCount[2]+=score[k];
                        }else
                        {
                            AllCount[3]+=score[k];
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++)
        {
            AllCount[i]/=all;
        }
        return AllCount;
    }
}
