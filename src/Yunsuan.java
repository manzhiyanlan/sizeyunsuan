import java.util.Scanner;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

//�����������������Ŀ
/*Ҫ��
 1.֧���������������� 
 2.��Ŀ�����ظ�
 3.�ɶ�������           
*/
public class Yunsuan {

    public static void main(String[] args) throws ScriptException {
        // TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        String fuhao[]=new String[4];
        fuhao[0]="+";
        fuhao[1]="-";
        fuhao[2]="*";
        fuhao[3]="/";
        
        int i,j,k,m=0;
        int M=0;int N1=0;
        
    System.out.print("��ѡ����Ŀ�����׳̶ȣ��������롰�ϼ򵥡� or �������ѡ���   ");
    String chengdu=scan.next();
    if(chengdu.equals("�ϼ�"))
        {M=100;N1=10;}
    else if(chengdu.equals("������"))
        {M=1000;N1=100;}
    else{
        System.out.println("��������");
    }
    System.out.println();
        System.out.print("����������������Ŀ������������");
        int N=scan.nextInt();
      
        //Part01
        ScriptEngine se=new ScriptEngineManager().getEngineByName("JavaScript");
        int dui=0;//���Ե���Ŀ
        String zuocuo="";//�������Ŀ
        String suan[]=new String[N];//��ʽ
        double key[]=new double[N];//��
        String K[]=new String[N];
        System.out.println();
        System.out.println("��Ŀ��ӡ���£�\n");
        System.out.println("�������������㡣");
        for(i=0;i<N;i++){
            int x=(int)(Math.random()*M); 
            int x2=(int)(Math.random()*M); 
            int y=(int)(Math.random()*M);
            int y2=(int)(Math.random()*M); 
            int z=(int)(Math.random()*4);
            int zz=(int)(Math.random()*4);
            int zzz=(int)(Math.random()*4);
            String output=x+fuhao[z]+y+fuhao[zz]+x2+fuhao[zzz]+
            y2;
             suan[i]=output+" =";
             
        }
        
        //�����ظ�
        for(j=0;j<N;j++){
            for(k=j+1;k<N-1;k++){
                if(suan[j].equals(suan[k]))
                {
            int x2=(int)(Math.random()*M); 
            int x22=(int)(Math.random()*M); 
            int y2=(int)(Math.random()*M);
            int y22=(int)(Math.random()*M); 
            int z2=(int)(Math.random()*4);
            int zz2=(int)(Math.random()*4);
            int zzz2=(int)(Math.random()*4);
            
            String output=
                    suan[k]=x2+" "+fuhao[z2]+" "+y2+" "+fuhao[zz2]+" "+x22+" "+fuhao[zzz2]+" "+
            y22;
            suan[k]=output+" =";
            key[i]=(int)se.eval(output);
                }
            }
        }
        for(m=0;m<N;m++){
            System.out.print(m+1+".  "+suan[m]);
            K[m]=scan.next();
            if(yanzheng(K[m],key[m])==1){
                dui++;
            }
            else{
                zuocuo+=" "+(m+1);
            }
            System.out.println();
        }
        System.out.println("������"+dui+"���⣬���"+zuocuo+"�Ĵ𰸴���");
        
      
    }//main
    //����
    public static int gongyue(int x,int y){
        int gongyue=1;
        int min=Math.min(x, y);
        for(int i=min;i>0;i--){
            if((x%i==0) && (y%i==0))
            {
                gongyue=i;
               break;
            }
        }//for
        return gongyue;    
    }
    //�ж����������Ƿ����
    public static int yanzheng(String x,double k){
        int m=0;
        String n=String.valueOf(k);
        if(x.equals(n)){
            m=1;//1Ϊ���
        }
        else
            m=0;
        return m;
    }
}//end