
package Manajemen_Rental_Elektronik;

import Manajemen_Rental_Elektronik.setget_adm;
import java.util.Date; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Administrasi extends javax.swing.JFrame {
Manajemen_Rental_Elektronik.setget_adm s = new Manajemen_Rental_Elektronik.setget_adm();
public static class Student
{
	String name;
	int id_no;
	String Stream;
	String book1,book2;
	int book_no,issuedbook;
	
	Student(String name,int id_no,String Stream)
	{
		this.name=name;
		this.id_no=id_no;
		this.Stream=Stream;
		
	}
}
  
public static class finaldsa 
{
	 void Selectionsort( Student arr[])
	{
	    int n = arr.length;
	    
	    for (int i = 0; i < n-1; i++)
	    {
	        int min_idx = i;
	        for (int j = i+1; j < n; j++)
	            if (arr[j].id_no < arr[min_idx].id_no)//Sort according to ID number of student
	                min_idx = j;

	        String temp1 = arr[min_idx].name;
	        arr[min_idx].name = arr[i].name;
	        arr[i].name = temp1;
	        
	        String temp2 = arr[min_idx].Stream;
	        arr[min_idx].Stream = arr[i].Stream;
	        arr[i].Stream = temp2;
	        
	    }
	}
	
	 void display(Student arr[])
	{
		 for(int i=0;i<arr.length;i++)
		 {
		 System.out.println("\nName of Student:" + arr[i].name);
		 System.out.println("\nId of Student:" + arr[i].id_no);
		 System.out.println("\nStream of Student:" + arr[i].Stream);
		 }
	}

	class Node 
	{
		String key; 
		Node left, right; 

		public Node(String item) 
		{ 
			key = item; 
			left = null;
			right=null; 
		} 
	} 

	Node root;
        Scanner input;
	finaldsa()
        {
	root = null;  
	} 

	//Insert Book
	void insert(String key) 
	{ 
		root = insertRec(root, key);
	} 

	Node insertRec(Node root, String key) 
	{ 
		if(root == null) 
		{ 
			root = new Node(key); 
			return root; 
		} 
		
		if (key.compareTo(root.key)<0) //If book name < root then place it as left child
			root.left = insertRec(root.left, key); 
		else if (key.compareTo(root.key)>0) //If book name > root then place it as Right child
			root.right = insertRec(root.right, key); 
		else
			System.out.println("error.");

		return root; 
	} 
	
	void update(String key,String key1) 
	{ 
		deleteKey(key);
		insert(key1);
	}

	//Search Book
	public boolean containsNode(String value) 
	{
		return containsNodeRecursive(root, value);
	}

	private boolean containsNodeRecursive(Node current, String key) 
	{
		if (current == null) 
		{
			return false;
		} 
		//If book name < root then place it as left child
		if (key.equalsIgnoreCase(current.key)) 
		{
			return true;
		} 
		
		//If book name < root then search at left side of root else right side
		return key.compareTo(current.key)<0
		? containsNodeRecursive(current.left, key)
		: containsNodeRecursive(current.right, key);
	}
	
	//print tree in 2D

	void printTree() 
    { 
        root = printTreeRec(root, 0); 
    } 
	
	Node printTreeRec(Node t , int space)
    {       
        if(t == null)
            return root;
       
        space += 5;
        
        printTreeRec(t.right ,space);
       
        System.out.println();
       
        for(int i = 5 ; i < space ; i++)
            System.out.print( " ");
        System.out.print("[" +t.key+ "]");
        
        return printTreeRec(t.left ,space);
    }


	
	void deleteKey(String key) 
    { 
        root = deleteRec(root, key); 
    } 
  
    Node deleteRec(Node root, String key) 
    { 
        if (root == null)  return root; 
  
      //If book name < root then search it at left side and delete
        if (key.compareTo(root.key)<0) 
            root.left = deleteRec(root.left, key); 
      //If book name > root then search it at right side and delete
        else if (key.compareTo(root.key)<0) 
            root.right = deleteRec(root.right, key); 
  
        else
        { 
            if (root.left == null) 
                return root.right; 
            else if (root.right == null) 
                return root.left; 
  
            root.key = minValue(root.right); 
  
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
  
    String minValue(Node root) 
    { 
        String minv = root.key; 
        while (root.left != null) 
        { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    } 
	//Print Books Inorder
	void printInorder(Node node) 
	{ 
		if (node == null) 
			return; 

		printInorder(node.left); 

		System.out.print(node.key + "		"); 

		printInorder(node.right); 
	} 

	void printInorder()    
	{
		printInorder(root);  
	} 

	void inorder()
	{ 
		inorderRec(root); 
	} 
   
	void inorderRec(Node root) 
	{ 
		if (root != null) 
		{ 
			inorderRec(root.left); 
			System.out.println(root.key); 
			inorderRec(root.right); 
		} 
	}
}    
        public Administrasi() {
        initComponents();
        
    }
      
        

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cb_pilihan = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        TF_hasil = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_hasil = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selamat Datang di Menu Administrasi");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jLabel2.setText("Silahkan Pilih : ");

        cb_pilihan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Input Barang", "View Barang", "Delete Barang", "Update Jumlah Barang", "View Barang In-order", "View Barang Tree", " " }));
        cb_pilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_pilihanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_pilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Nama Barang : ");

        jLabel4.setText("Jumlah Barang :");

        TA_hasil.setColumns(20);
        TA_hasil.setRows(5);
        jScrollPane1.setViewportView(TA_hasil);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TF_hasil)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(TF_hasil, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cb_pilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_pilihanActionPerformed
   
    }//GEN-LAST:event_cb_pilihanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);
        finaldsa tree = new finaldsa();
	HashMap<String, Integer> hashmapping = new HashMap<>();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		Student[] array = new Student[3];
		//Add student Details
		array[0]=new Student("alfan",1901010033,"ILKOM");
		array[1]=new Student("arik",1901010046,"ILKOM");
		array[2]=new Student("putu",1901010011,"ILKOM");
		int [][] arr=new int[100][2];
		
		//Create file to store data of students.
		FileWriter fr = new FileWriter("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\append.txt", true);
		BufferedWriter br = new BufferedWriter(fr);
		
		FileWriter fr1 = new FileWriter("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\append.txt", true);
		BufferedWriter br1 = new BufferedWriter(fr1);
		
		FileWriter fr2 = new FileWriter("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\append.txt", true);
		BufferedWriter br2 = new BufferedWriter(fr2);
		
		FileWriter fr3 = new FileWriter("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\append.txt", true);
		BufferedWriter br3 = new BufferedWriter(fr3);
		
		FileReader file = new FileReader("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\x.txt");			
		BufferedReader reader = new BufferedReader(file);	
		
		FileReader file2= new FileReader("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\y.txt");			
		BufferedReader reader2 = new BufferedReader(file2);	
		
		FileReader file3= new FileReader("C:\\Users\\DarkBlue\\Documents\\NetBeansProjects\\Analisis_algoritma\\src\\adm_data\\z.txt");			
		BufferedReader reader3 = new BufferedReader(file3);	
		Date Rday1 = null,Rday2 = null,Cday=null;
                
                
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrasi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TA_hasil;
    private javax.swing.JTextField TF_hasil;
    private javax.swing.JComboBox<String> cb_pilihan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtnama;
    // End of variables declaration//GEN-END:variables
}
