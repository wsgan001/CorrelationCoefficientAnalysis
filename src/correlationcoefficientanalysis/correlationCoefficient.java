/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package correlationcoefficientanalysis;

/**
 *
 * @author 小詠
 */ 
//code Check is ok by excel
public class correlationCoefficient
{
   
    public static double[][] correlationCoefficient(double[][] namevector, int namequantity, int documentquantity)
    {
        double cor[][] = new double[namequantity][namequantity];
        double avg[] = new double[namequantity];
        //計算每一個人名的平均數
        for(int i = 0 ; i < namequantity ; i ++)
        {
            for(int j = 0 ; j < documentquantity ; j ++)
            {
                avg[i]+=namevector[i][j];
            }
            avg[i] = avg[i]/documentquantity;
        }
        //計算平方開根號項
        double sqrtSquare[] = new double[namequantity];
        for(int i = 0 ; i < namequantity ; i ++)
        {
            for(int j = 0 ; j < documentquantity ; j ++)
            {
                sqrtSquare[i]+=Math.pow(namevector[i][j]-avg[i],2);
            }
            sqrtSquare[i]=Math.pow(sqrtSquare[i], 0.5);
        }
        //計算相關係數
        double numeratorOfCor[][] = new double[namequantity][namequantity];
        for(int i = 0 ; i < namequantity ; i ++)
        {
            for(int j = 0 ; j < namequantity ; j ++)
            {
                for(int k = 0 ; k < documentquantity ; k ++)
                {
                    numeratorOfCor[i][j]+=((namevector[i][k]-avg[i])*(namevector[j][k]-avg[j]));
                }
                cor[i][j]=numeratorOfCor[i][j]/(sqrtSquare[i]*sqrtSquare[j]);
            }
        }
        return cor;
    }

}
