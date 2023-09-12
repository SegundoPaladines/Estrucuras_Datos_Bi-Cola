package cola;
import javax.swing.JOptionPane;

public class Cola {	
     
    private Nodo pri,ult;    
    
    public Cola () {
        pri  =null;
        ult = null;
    }
    
    
    public void insertarPrimero() {
    	Nodo nue;
        nue = new Nodo();        
        int informacion;
        informacion = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL ITEM A AGREGAR"));        
        nue.info = informacion;
        nue.sig = null;

        if (pri==null)
        {            
            pri = nue;
            pri.ant=null;
            ult = pri;
            ult.ant=null;
            //ult.sig = null;
        }
        else
        {
            nue.sig=pri;
            pri.ant=nue;
            pri=nue;
        }
    }
   
    public void insertarUltimo() {
    	Nodo nue;
        nue = new Nodo();        
        int informacion;
        informacion = Integer.parseInt(JOptionPane.showInputDialog(null,"INGRESE EL ITEM A AGREGAR"));        
        nue.info = informacion;
        nue.sig = null;

        if (pri==null)
        {            
            pri = nue;
            pri.ant=null;
            ult = pri;
            ult.ant=null;
            //ult.sig = null;
        }
        else
        {
            ult.sig = nue;
            nue.ant=ult;
            ult = nue;
        }
    }

    public int extraerPrimero ()
    {
        if (pri!=null)
        {
            int informacion = pri.info;
            pri = pri.sig;
            if(pri!=null){
                pri.ant=null;
            }
            return informacion;            
        }
        else
        {
            return -1;
        }
    }

    public int extraerUltimo ()
    {
        if (pri==ult)
        {
            int informacion = ult.info;
            pri=null;
            ult=null;
            return informacion;
                        
        }else if(pri!=null){
            int informacion = ult.info;
            Nodo aux=pri;
            while(!(aux.sig==ult)){
                aux=aux.sig;
            }
            aux.sig=null;
            this.ult=aux;
            return informacion;
        }
        else
        {
            return -1;
        }
    }
    
    public void imprimir() {
        if (pri!=null)
       	{        
	        Nodo aux=pri;	        
	        System.out.println("Datos de la Cola:\n");
	        while (aux!=null) {
	            System.out.print(aux.info+" -> ");
	            aux=aux.sig;
	        }
	        System.out.println();
	        }
        else
        	System.out.println("Cola vacia.");
    }
    
    
    public void vaciarCola() {
        if (pri!=null)
       	{        
	        Nodo aux=pri;	        	        
	        while (aux!=null) {
	            System.out.print("Liberado: " + aux.info+"\n");
				pri = pri.sig;	            
	            aux=null;
	            aux = pri;
	        }	        
	    }    
        System.out.println("Cola vacia.");
    }   
    
    
    public static void main(String[] ar) {
    	int Opcion,dato;        
    	Cola Cola1=new Cola();
        do
        {
            Opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "1. INGRESAR PRIMERO\n"+
                    "2. INGRESAR ULTIMO\n"+
                    "3. SACAR PRIMERO\n"+
                    "4. SACAR ULTIMO\n"+
                    "5. LISTAR Cola\n"+
                    "6. VACIAR Cola\n"+
                    "7. SALIR\n"+
                    "--------------------------------------------------------\n"+
                    "INGRESE LA OPCION [1 - 5]","MENU Cola",JOptionPane.QUESTION_MESSAGE));
            
            switch(Opcion)
            {
                case 1: Cola1.insertarPrimero();break;
                case 2: Cola1.insertarUltimo();break;
                case 3:
                    dato = Cola1.extraerPrimero();
                    if(dato !=-1)
                        System.out.println("Sale de Cola: "+dato);             
                    else
                        System.out.println("Cola vacia.");
                break;
                case 4:
                dato = Cola1.extraerUltimo();
                if(dato !=-1)
                    System.out.println("Sale de Cola: "+dato);             
                else
                    System.out.println("Cola vacia.");
                break;
                case 5: Cola1.imprimir();break;
                case 6: Cola1.vaciarCola();break;
                case 7: System.exit(0);break;
                default: JOptionPane.showMessageDialog(null,"INGRESE UNA OPCION VALIDA \n","ERROR OPCION",JOptionPane.WARNING_MESSAGE);break;
            }
        }
        while(true); 
    }
}
    	    	