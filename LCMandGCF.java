import java.util.Random;

public class LCMandGCF
{  
	Random rand = new Random();
    int GCF(int num1, int num2)
    {
        int i, hcf=0;
        for(i=1; i<=num1 || i<=num2; i++)
        {
            if(num1%i==0 && num2%i==0)
            {
                hcf=i;
            }
        }
        return hcf;
    }
    int LCM(int num1, int num2) {
    	return (num1/this.GCF(num1, num2)) * num2;
    }
    int GCF3(int num1, int num2, int num3)
    {
        int i, hcf=0;
        for(i=1; i<=num1 || i<=num2; i++)
        {
            if(num1%i==0 && num2%i==0)
            {
                hcf=i;
            }
        }
        return GCF(hcf,num3);
    }
    
    void LCM3(int num1) {
    	double num2 = num1 * 1.5;
    	double num3 = num1 * 2;
    }
}