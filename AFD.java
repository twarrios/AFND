import static javax.swing.JOptionPane.*;
import java.util.regex.*;

public class AFD {

	static int c_pa = 0;
	static int c = 0;
	static int tam = 0;
	static String cad = "";
	static String error = "La expresión no es valida";


	public static boolean seccion(int parentesis){
		if (parentesis == 0) {		return true;}
		else		{return 	false;}
	}

	public static void q0(String exp[]){
		if(exp[c].matches("[a-z]")){
			cad +="\nqo , "+exp[c]+" --> q1";
			c++;
			q1(exp);
		}
		else if(exp[c].equals("(")){
			c_pa++;
			cad +="\nqo , "+exp[c]+" --> q0";
			c++;
			q0(exp);
		}
		else{
			muestra(error);
		}
	}

	public static void q1(String exp []){
		if (c == tam){
			if(seccion(c_pa)){
				muestra(cad);
			}
			else{muestra(error);}
		}
		else if((String.valueOf( exp[c] ).matches( "[-+*/]" )) && (c != tam)){
			cad +="\nq1 , "+exp[c]+" --> q2";
			c++;
			q2(exp);
		}
		else if((exp[c].equals(")")) && (c != tam)){
			c_pa--;
			cad +="\nq1 , "+exp[c]+ " --> q1";
			c++;
			q1(exp);
		}
		else{
			muestra(error);
		}
	}

	public static void q2(String exp []){
		if(exp[c].matches("[a-z]")){
			cad +="\nq2 , "+exp[c]+" --> q1";
			c++;
			q1(exp);
		}
		else if(exp[c].equals(")")){
			c_pa--;
			cad +="\nq2 , "+exp[c]+" --> q0";
			q0(exp);
		}
		else{
			muestra(error);
		}
	}

	public static void muestra(String a){
		showMessageDialog(null,a);
	}


	public static void is_validate(String exp){
		if(exp.isEmpty()){
			showMessageDialog(null,error);
		}
		else{
			tam += exp.length();
			q0(exp.split(""));}
	}

	public static void main(String[] args) {
		 String exp = showInputDialog("Ingrese una expresion");
		 is_validate(exp);
	}
}