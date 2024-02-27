// package UserInterface.GUI;

// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;

// import javax.swing.JLabel;
// import javax.swing.JOptionPane;
// import javax.swing.JPanel;
// import javax.swing.JScrollPane;
// import javax.swing.JTable;
// import javax.swing.border.Border;
// import javax.swing.border.CompoundBorder;
// import javax.swing.border.EmptyBorder;
// import javax.swing.border.LineBorder;
// import javax.swing.event.ListSelectionEvent;
// import javax.swing.event.ListSelectionListener;
// import UserInterface.CustomerControl.SIAButton;
// import UserInterface.CustomerControl.SIALabel;
// import UserInterface.CustomerControl.SIATextBox;

// import javax.swing.JLabel;

// public class Principal extends JPanel implements ActionListener{

//     public Principal() throws Exception{
//         setGridBagLayout();

//         btnGuardar.addActionListener(this);

//         // Otra forma de poner escuchadores
//     }

//     private SIALabel  
//             lblTitulo  = new SIALabel("SIA"          );
//     private SIATextBox  
//             txtIdSexo  = new SIATextBox (),
//             txtNombre  = new SIATextBox ();

//     private SIAButton            
//             btnGuardar = new SIAButton("Guardar"),
//             btnRegar= new SIAButton("Regar");
//     private JPanel 
//             pnlTabla   = new JPanel(),
//             pnlBtnCRUD = new JPanel(new FlowLayout()),
//             pnlBtnPage = new JPanel(new FlowLayout());
//     private Border  
//             line       = new LineBorder(Color.lightGray),
//             margin     = new EmptyBorder(5, 5, 5, 5),
//             border     = new CompoundBorder(line, margin);
//     public void setGridBagLayout(){
//         GridBagConstraints gbc= new GridBagConstraints();
//         txtIdSexo.setEnabled(false);
        
//         // Panel.Paginacion.Tabla

//         // Panel.CRUD
//         pnlBtnCRUD.add(btnGuardar);
//         pnlBtnCRUD.add(btnRegar);
//         pnlBtnCRUD.setBorder(border);

//         // GridBagConstraints.Separación entre componentes
//         gbc.insets=new Insets(5,5,5,5);    
        
//         // GridBagConstraints.ponerComponentes
//         gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
//         gbc.gridwidth=3;                   //| celdas a unir
//         add(lblTitulo, gbc);               //| agrega el control

//         gbc.gridy = 1;       gbc.gridx=0;   
//         gbc.gridwidth=1;                     
//         add(new JLabel("■ Sección de datos: "), gbc);                 

//         gbc.gridy = 2;       gbc.gridx=0;
//         gbc.gridwidth=3;                   //| celdas a unir
//         gbc.ipady = 150;                   //| tamaño alto
//         gbc.ipadx = 450;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
//         pnlTabla.add(new Label("Loading data..."));
//         //pnlTabla.setBorder(border);
//         add(pnlTabla, gbc);
        
//         gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
//         gbc.ipadx = 1;
        
//         gbc.gridy = 3;       gbc.gridx=0;   
//         gbc.gridwidth=3;  
//         add(pnlBtnPage, gbc);  

//         gbc.gridy = 4;       gbc.gridx=0; 
//         gbc.gridwidth=1;    
//         add(new JLabel("■ Sección de registro: "), gbc);  

//         gbc.gridy = 5;       gbc.gridx=1;     add(txtIdSexo,  gbc);   

//         gbc.gridy = 6;       gbc.gridx=1;     add(txtNombre, gbc);
//         gbc.gridy = 6;       gbc.gridx=2;     add(new JLabel("*"), gbc);  

//         gbc.gridy = 7;       gbc.gridx=0;
//         gbc.gridwidth=3;
//         gbc.insets    = new Insets(30,0,0,0); 
//         gbc.fill=GridBagConstraints.HORIZONTAL;
//         add(pnlBtnCRUD, gbc);
//     }
//     @Override
//     public void actionPerformed(ActionEvent e) {
//         // TODO Auto-generated method stub
//         throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
//     }
// }
