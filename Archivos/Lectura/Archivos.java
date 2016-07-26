import java.io.*;//in-out 
public class Archivos{
	public static void main(String[] args){
		FileReader reader=null; //Crear un lector de archivos 
		BufferedReader buffer=null; //Creación un buffer
		try{
			System.out.println("-----Letra por Letra-----");
			reader = new FileReader("EntrAda.txt"); //Asignar un archivo al lector
			System.out.println("Archivo Encontroado"); 
			buffer= new BufferedReader(reader); //Asignar un lector al buffer
			System.out.println("Buffer Abierto");
			System.out.println("Leyendo Buffer");			
			while(buffer.ready()){ //Mientras que el buffer se pueda leer
				int index=buffer.read();//index para manter la misma letra dentro del ciclo
				if(Character.toChars(index)[0]=='C'){//Saltarse caracteres
					buffer.skip(5);//cantidad de caracteres a saltar
					index=buffer.read();//saltar la letra actual
				}
				System.out.print(Character.toChars(index)[0]);//Imprimir letra actual y avanza a la siguiente
				
			}
			System.out.println("Buffer Leido");	
			System.out.println("-----Linea por linea-----");
			//------------Linea por linea----------------------------
			//Ya leimos todo el archivo si lo leemos de nuevo da error
			//volvermos a  asignar el reader y el buffer
			reader=new FileReader("Entrada.txt");
			System.out.println("Archivo Encontroado"); 
			buffer=new BufferedReader(reader);
			System.out.println("Buffer Abierto");
			System.out.println("Leyendo Buffer");			
			while(buffer.ready()){				
				System.out.println(buffer.readLine());
			}
			System.out.println("Buffer Leido");	

		}
		catch(IOException error){
			System.err.println(error.getMessage());			
		}
		finally{// el bloque finally se ejecuta siempre que termine el try o el catch
			if(buffer != null){
				try{
				buffer.close();  //cerrar el buffer sin importar el motivo de salida 
				System.out.println("Buffer Cerrado");
				}
				catch(IOException e){
					System.err.println(e.getMessage());
				}
			}
		}
	}
}