import java.io.*;//in-out 
public class Archivos{
	public static void main(String[] args){
		FileReader reader=null; //Crear un lector de archivos 
		BufferedReader buffer=null; //Creación un buffer
		try{
			reader = new FileReader("EntrAda.txt"); //Asignar un archivo al lector
			System.out.println("Archivo Encontroado"); 
			buffer= new BufferedReader(reader); //Asignar un lector al buffer
			System.out.println("Buffer Abierto");
			int index=buffer.read(); //Crear y asignar índice al buffer->primer letra
			System.out.println("Leyendo Buffer");			
			while(index != -1){// -1 es el final del archivo
				System.out.print(Character.toChars(index)); //Imprimir letra actual
				index=buffer.read(); //avanzar a la siguiente letra
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