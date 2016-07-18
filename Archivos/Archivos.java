import java.io.*;//in-out 
public class Archivos{
	public static void main(String[] args){
		try{
			FileReader reader = new FileReader("EntrAda.txt"); 
			//Si logra encontrar el archivo... 
			//Escriba su código aquí
			BufferedReader buffer= new BufferedReader(reader);
			//Leer archivo linea por linea
			
			//while(buffer.ready()){
			//	System.out.println(buffer.readLine());
			//}
			
			//Leer el archivo letra por letra
			//Character		char 	
			int letra=buffer.read();
			while(letra != -1){
				System.out.print(Character.toChars(letra));
				
				letra = buffer.read();
			}
		}
		catch(IOException error){
			System.err.println(error.getMessage());			
		}
	}
	
}