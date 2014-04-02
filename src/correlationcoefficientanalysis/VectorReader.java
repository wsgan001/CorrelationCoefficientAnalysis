/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package correlationcoefficientanalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author 小詠
 */
public class VectorReader
{
    //回傳namevector
    public static double[][] vectorReader(String filePath) throws FileNotFoundException, IOException
    {
        //自動計算人名數量與人名長度 (code check is ok)
        int namequantity = 0;
        int documentquantity = 0;
        FileReader fileReader1 = new FileReader(filePath);
        BufferedReader buffileReader1 = new BufferedReader(fileReader1);
        while(buffileReader1.ready())
        {
            StringTokenizer st = new StringTokenizer(buffileReader1.readLine());
            while(st.hasMoreTokens())
            {
                st.nextToken();
                namequantity ++;
            }
            documentquantity++;
        }
        namequantity = namequantity/documentquantity;
        double namevector[][] = new double[namequantity][documentquantity];
        //讀取人名 (code check is ok)
        int controlName = 0;
        int controlDoc = 0;
        FileReader fileReader2 = new FileReader(filePath);
        BufferedReader buffileReader2 = new BufferedReader(fileReader2);
        while(buffileReader2.ready())
        {
            StringTokenizer st = new StringTokenizer(buffileReader2.readLine());
            while(st.hasMoreTokens())
            {
                namevector[controlName%namequantity][controlDoc] = Double.parseDouble(st.nextToken());
                controlName++;
            }
            controlDoc++;
        }
        return namevector;
    }
    //回傳namequantity
    public static int getnamequantity(String filePath) throws FileNotFoundException, IOException
    {
        //自動計算人名數量與人名長度 (code check is ok)
        int namequantity = 0;
        int documentquantity = 0;
        FileReader fileReader1 = new FileReader(filePath);
        BufferedReader buffileReader1 = new BufferedReader(fileReader1);
        while(buffileReader1.ready())
        {
            StringTokenizer st = new StringTokenizer(buffileReader1.readLine());
            while(st.hasMoreTokens())
            {
                st.nextToken();
                namequantity ++;
            }
            documentquantity++;
        }
        namequantity = namequantity/documentquantity;
        return namequantity;
    }
    //回傳documentquantity
    public static int getdocumentquantity(String filePath) throws FileNotFoundException, IOException
    {
        //自動計算人名數量與人名長度 (code check is ok)
        int namequantity = 0;
        int documentquantity = 0;
        FileReader fileReader1 = new FileReader(filePath);
        BufferedReader buffileReader1 = new BufferedReader(fileReader1);
        while(buffileReader1.ready())
        {
            StringTokenizer st = new StringTokenizer(buffileReader1.readLine());
            while(st.hasMoreTokens())
            {
                st.nextToken();
                namequantity ++;
            }
            documentquantity++;
        }
        namequantity = namequantity/documentquantity;
        return documentquantity;
    }
}
