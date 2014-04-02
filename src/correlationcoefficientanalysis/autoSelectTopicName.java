/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package correlationcoefficientanalysis;

/**
 *
 * @author 陳仲詠
 */
public class autoSelectTopicName 
{
    public static String autoSelectTopicName(int i)
    {
        String str="";
        switch(i)
        {
            case 1:
                str="2009NBASemi";
                break;
            case 2:
                str="2012NBASemi";
                //str="2012UEFA";
                break;
            case 3:
                //str="2008NBASemi";
                str="2011nfl";
                break;
            case 4:
                str="2011NBASemi";
                break;
            case 5:
                str="imf";
                break;
            case 6:
                str="opec";
                break;
            case 7:
                //str="greece";
                str="greecebailout";
                break;
            case 8:
                str="microsoft";
                break;
            case 9:
                str="russia";
                break;
            case 10:
                str="french";
                break;
            case 11:
                str="mexico";
                break;
            case 12:
                str="korea";
                break;
            default :
                System.out.println("找不到相關資料夾");
        }
        return str;
    }
    
}
