package UserInterface.GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BusinessLogic.DatoRiegoBL;
import DataAccess.DTO.DatoRiegoDTO;
import UserInterface.CustomerControl.JPButton;
import UserInterface.CustomerControl.JPLabel;
import UserInterface.CustomerControl.JPTextBox;

public class JPPanelSIA extends JPanel implements ActionListener{
    private Integer idDato, idMaxDato;
    private DatoRiegoBL  datoRiegoBL  = null;
    private DatoRiegoDTO   datoRiegoDTO  = null;

    public JPPanelSIA() throws Exception{
        setGridBagLayout();
        loadData();
        showData();
        showTable();

        btnIni.addActionListener(this);
        btnAnt.addActionListener(this);
        btnSig.addActionListener(this);
        btnFin.addActionListener(this);
        btnGuardar.addActionListener(this);

        // Otra forma de poner escuchadores
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   btnNuevoClick(e);   }
        });

        btnEliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {   try {
                btnEliminarClick(e);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }   
            }
        });
    }
    
    private void loadData() throws Exception {
        idDato      = 1;
        datoRiegoBL      = new DatoRiegoBL();
        datoRiegoDTO        = datoRiegoBL.getByIdDato(idDato);
        //idMaxDato   = datoRiegoBL.getMaxIdSexo();
    }
    private void showData() {
        boolean datoNull = (datoRiegoDTO == null);
        txtIdDato.setText((datoNull) ? " " : datoRiegoDTO.getIdDato().toString());            
        txtHumedad.setText((datoNull) ? " " : datoRiegoDTO.getHumedadSuelo().toString());
        txtIdTipodeRiego.setText((datoNull) ? " " : datoRiegoDTO.getIdTipoRiego().toString());
        txtFechaCrea.setText((datoNull) ? " " : datoRiegoDTO.getFechaCrea());
        txtFechaModifica.setText((datoNull) ? " " : datoRiegoDTO.getFechaModifica());
        //lblTotalReg.setText(idDato.toString() + " de " + idMaxDato.toString());
    }
    private void btnNuevoClick(ActionEvent e) {
        datoRiegoDTO = null;
        showData();
    } 
    private void btnEliminarClick(ActionEvent e) throws Exception {
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea Eliminar?", "Eliminar...",
        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
               
            if(!datoRiegoBL.delete(datoRiegoDTO.getIdDato()))
                JOptionPane.showMessageDialog(this, "Error al eliminar...!", "ERROR", JOptionPane.OK_OPTION);

            loadData();
            showData();
            showTable();
        }
    }
    private void btnGuardarClick(ActionEvent e) throws  Exception {
        boolean datoNull = (datoRiegoDTO == null);
        if (JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar?", (datoNull)?"Agregar...": "Actualizar...", 
            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            
            // if (datoNull)
            //     datoRiegoDTO = new DatoRiegoBL(txtHumedad.getText().toString());
            // else
            //     datoRiegoDTO.setHumedadSuelo(txtHumedad.getText().toString());

            // if(!((datoNull) ? datoRiegoBL.create(datoRiegoDTO) : datoRiegoBL.update(datoRiegoDTO)))
            //     JOptionPane.showMessageDialog(this, "Error al guardar...!", "ERROR", JOptionPane.OK_OPTION);
            
            loadData();
            showData();
            showTable();
        }
    } 
    private void showTable() throws Exception {
        String[] header = {"Id", "Humedad", "Tipo de Riego","Fecha Creacion","Fecha Modifica"};
        Object[][] data = new Object[datoRiegoBL.getAll().size()][5];  
        int index = 0;
        for(DatoRiegoDTO r : datoRiegoBL.getAll()) {
            data[index][0] = r.getIdDato();
            data[index][1] = r.getHumedadSuelo();
            data[index][2] = r.getIdTipoRiego();
            data[index][3] = r.getFechaCrea();
            data[index][4] = r.getFechaModifica();
            index++;
        }
        
        JTable table  = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.lightGray);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 150));
        table.setFillsViewportHeight(true);

        //table.setBorder(border);
        // pnlTabla.setBorder( BorderFactory.createTitledBorder(
        //                     BorderFactory.createEtchedBorder(), " SEXO ", TitledBorder.CENTER, TitledBorder.TOP));
      
        pnlTabla.removeAll();
        pnlTabla.add(table);
        JScrollPane scrollPane = new JScrollPane(table);
        pnlTabla.add(scrollPane);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){ 
            @Override
            public void valueChanged(ListSelectionEvent e) {
          
                int col = 0;
                int row = table.getSelectedRow();
                String strIdDato = table.getModel().getValueAt(row, col).toString();

                idDato = Integer.parseInt(strIdDato);
                try {
                    datoRiegoDTO    = datoRiegoBL.getByIdDato(idDato);
                    showData(); 
                } catch (Exception e1) { }  
                System.out.println("Tabla.Selected: " + strIdDato);
            }
        });
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnIni)
            idDato  = 1;
        if(e.getSource() == btnAnt  &&  (idDato>1) )
            idDato--;
        if(e.getSource() == btnSig  &&  (idDato<idMaxDato))
            idDato++;
        if(e.getSource() == btnFin)
            idDato = idMaxDato;

        // try {
        //     if(e.getSource() == btnGuardar)
        //         btnGuardarClick(e);
        //     datoRiegoDTO    = DatoRiegoBL.getSexoById(idDato);  
        //     showData(); 
        // } catch (Exception ex) {}
        // System.out.println(e.getActionCommand());
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private JPLabel  
            lblTitulo  = new JPLabel("RIEGO"          ),
            lblIdDato  = new JPLabel("Riego:      " ),
            lblHumedad  = new JPLabel("Humedad " ),
            lblTotalReg= new JPLabel("  0 de 0  "    );
    private JPTextBox  
            txtIdDato  = new JPTextBox (),
            txtHumedad  = new JPTextBox (),
            txtIdTipodeRiego  = new JPTextBox (),
            txtFechaCrea  = new JPTextBox (),
            txtFechaModifica  = new JPTextBox ();
    private JPButton  
            btnIni     = new JPButton(" |< "), 
            btnAnt     = new JPButton(" << "),            
            btnSig     = new JPButton(" >> "),
            btnFin     = new JPButton(" >| ");
    private JPButton
            btnNuevo   = new JPButton("Nuevo"),            
            btnGuardar = new JPButton("Guardar"),
            btnCancelar= new JPButton("Cancelar"),
            btnEliminar= new JPButton("Eliminar");
    private JPanel 
            pnlTabla   = new JPanel(),
            pnlBtnCRUD = new JPanel(new FlowLayout()),
            pnlBtnPage = new JPanel(new FlowLayout());
    private Border  
            line       = new LineBorder(Color.black),
            margin     = new EmptyBorder(12, 12, 12, 12),
            border     = new CompoundBorder(line, margin);
    
/************************
 * Customize : Form
 ************************/ 
    public void setGridBagLayout(){
        //setLayout(new GridBagLayout());
        GridBagConstraints gbc= new GridBagConstraints();
        txtIdDato.setEnabled(false);
        
        // Panel.Paginacion.Tabla
        pnlBtnPage.add(btnIni);       
        pnlBtnPage.add(btnAnt);  
        pnlBtnPage.add(new JPLabel(" Page: [ "));      
        pnlBtnPage.add(lblTotalReg);        
        pnlBtnPage.add(new JPLabel(" ] "));      
        pnlBtnPage.add(btnSig);
        pnlBtnPage.add(btnFin);

        // Panel.CRUD
        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(border);

        // GridBagConstraints.Separación entre componentes
        gbc.insets=new Insets(12,12,12,12);    
        
        // GridBagConstraints.ponerComponentes
        gbc.gridy = 0;       gbc.gridx=0;  //| fila,  columna
        gbc.gridwidth=6;                   //| celdas a unir
        add(lblTitulo, gbc);               //| agrega el control

        gbc.gridy = 2;       gbc.gridx=0;   
        gbc.gridwidth=2;                     
        add(new JLabel("■ Sección de datos: "), gbc);                 

        gbc.gridy = 2;       gbc.gridx=0;
        gbc.gridwidth=5;                   //| celdas a unir
        gbc.ipady = 200;                   //| tamaño alto
        gbc.ipadx = 550;                   //| tamaño ancho ... luego se debe restablecer a 1 o 0
        pnlTabla.add(new Label("Loading data..."));
        //pnlTabla.setBorder(border);
        add(pnlTabla, gbc);
        
        gbc.ipady = 1;                    //| Restablecer el tamaño de fila y columna
        gbc.ipadx = 1;
        
        gbc.gridy = 3;       gbc.gridx=0;   
        gbc.gridwidth=3;  
        add(pnlBtnPage, gbc);  

        gbc.gridy = 4;       gbc.gridx=0; 
        gbc.gridwidth=1;    
        add(new JLabel("■ Sección de registro: "), gbc);  

        gbc.gridy = 5;       gbc.gridx=0;     add(lblIdDato,  gbc);   
        gbc.gridy = 5;       gbc.gridx=1;     add(txtIdDato,  gbc);   

        gbc.gridy = 6;       gbc.gridx=0;     add(lblHumedad, gbc);        
        gbc.gridy = 6;       gbc.gridx=1;     add(txtHumedad, gbc);
        gbc.gridy = 6;       gbc.gridx=2;     add(new JLabel("*"), gbc);  

        gbc.gridy = 7;       gbc.gridx=0;
        gbc.gridwidth=3;
        gbc.insets    = new Insets(30,0,0,0); 
        gbc.fill=GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
        
        //  gbc.gridy=8;     gbc.gridx=2;
        //  add(b5,gbc);
        
        //  gbc.gridy=9;     gbc.gridx=2;
        //  add(b6,gbc);

        //  gbc.gridy=7;        gbc.gridx=0;
        //  gbc.gridwidth=2;
        //  gbc.gridheight=2;
        //  gbc.fill=GridBagConstraints.BOTH;
        //  add(b4,gbc);
    }

}
