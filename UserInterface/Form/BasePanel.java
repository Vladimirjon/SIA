package UserInterface.Form;

import javax.swing.*;

import BusinessLogic.DatoRiegoBL;
import DataAccess.DTO.DatoRiegoDTO;
import UserInterface.IAStyle;
import UserInterface.CustomerControl.JPButton;
import UserInterface.CustomerControl.JPLabel;
import UserInterface.CustomerControl.JPTextBox;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BasePanel  extends JPanel implements ActionListener {
    private Integer idDato = 0, idMaxDato=0;
    private DatoRiegoBL datoRiegoBL = null;
    private DatoRiegoDTO datoRiegoDTO = null;

    public BasePanel() {
        try {
            customizeComponent();
            loadRow();
            showRow();
            showTable();

            btnRowIni.addActionListener(this);
            btnRowAnt.addActionListener(this);
            btnRowSig.addActionListener(this);
            btnRowFin.addActionListener(this);
            
            btnNuevo.addActionListener(     e -> btnNuevoClick());
            btnGuardar.addActionListener(   e -> btnGuardarClick());
            btnEliminar.addActionListener(  e -> btnEliminarClick());
            btnCancelar.addActionListener(  e -> btnCancelarClick());
        } catch (Exception e) {
            IAStyle.showMsg(e.getMessage());
        }
    }

    private void loadRow() throws Exception {
        idDato      = 1;
        datoRiegoBL      = new DatoRiegoBL();
        datoRiegoDTO        = datoRiegoBL.getByIdDato(idDato);
        // idMaxDato   = datoRiegoBL.getMaxRow();
    }

    private void showRow() {
        boolean datoNull = (datoRiegoDTO == null);
        txtIdData.setText((datoNull) ? " " : datoRiegoDTO.getIdDato().toString());
        txtHumedad.setText((datoNull) ? " " : datoRiegoDTO.getHumedadSuelo().toString());
        txtIdTipoRiego.setText((datoNull) ? " " : datoRiegoDTO.getIdTipoRiego().toString());
        txtFechaCrea.setText((datoNull) ? " " : datoRiegoDTO.getFechaCrea());
        txtFechaModifica.setText((datoNull) ? " " : datoRiegoDTO.getFechaModifica());
        lblTotalReg.setText(idDato.toString() + " de " + idMaxDato.toString());
    }

    private void btnNuevoClick() {
        datoRiegoDTO = null;
        showRow();
    } 
    
    private void btnGuardarClick() {
        boolean datoNull = (datoRiegoDTO == null);
        // String buttonText = ((JButton) e.getSource()).getText();
        // try {
        //     if (IAStyle.showConfirmYesNo("¿Seguro que desea " + ((datoNull) ? "AGREGAR ?" : "ACTUALIZAR ?"))){
            
        //         if (datoNull)
        //             datoRiegoDTO = new DatoRiegoDTO(txtHumedad.getText());
        //         else
        //             datoRiegoDTO.setHumedadSuelo(txtHumedad.getText());
    
        //         if(!((datoNull) ? datoRiegoBL.create(datoRiegoDTO) : datoRiegoBL.update(datoRiegoDTO)))
        //             IAStyle.showMsgError("Error al guardar...!");
    
        //         loadRow();
        //         showRow();
        //         showTable();
        //     }
        // } catch (Exception e) {
        //     IAStyle.showMsgError(e.getMessage());
        // }
    }

    private void btnEliminarClick() {
        try {
            if (IAStyle.showConfirmYesNo("Seguro que desea Eliminar?")) {

                if (!datoRiegoBL.delete(datoRiegoDTO.getIdDato()))
                    throw new Exception("Error al eliminar...!");
    
                loadRow();
                showRow();
                showTable();
            }
        } catch (Exception e) {
            IAStyle.showMsgError(e.getMessage());
        }
    }

    private void btnCancelarClick() {
        try {
            if(datoRiegoDTO == null)
                loadRow();
            showRow();
        } catch (Exception e) {}
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRowIni)
            idDato = 1;
        if (e.getSource() == btnRowAnt && (idDato > 1))
            idDato--;
        if (e.getSource() == btnRowSig && (idDato < idMaxDato))
            idDato++;
        if (e.getSource() == btnRowFin)
            idDato = idMaxDato;
        try {
            datoRiegoDTO    = datoRiegoBL.getByIdDato(idDato);  
            showRow(); 
        } catch (Exception ex) {}
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

        JTable table = new JTable(data, header);
        table.setShowHorizontalLines(true);
        table.setGridColor(Color.BLACK);
        table.setRowSelectionAllowed(true);
        table.setColumnSelectionAllowed(false);

        table.setPreferredScrollableViewportSize(new Dimension(450, 170));
        table.setFillsViewportHeight(true);

        pnlTabla.removeAll();
        pnlTabla.add(new JScrollPane(table));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
                if (row >= 0 && col >= 0) {
                    String strIdDato = table.getModel().getValueAt(row, 0).toString();
                    idDato = Integer.parseInt(strIdDato);
                    try {
                        datoRiegoDTO = datoRiegoBL.getByIdDato(idDato);
                        showRow();
                    } catch (Exception ignored) {
                    }
                    System.out.println("Tabla.Selected: " + strIdDato);
                }
            }
        });
    }

/************************
 * FormDesing : pat_mic
 ************************/ 
    private JPLabel 
            lblTitulo   = new JPLabel("REGISTRO DE RIEGOS"),
            lblIdDato   = new JPLabel(" Num. Riego :      "),
            lblHumedad   = new JPLabel(" Humedad : "),
            lblTotalReg = new JPLabel(" 0 de 0 ");
    private JPTextBox 
            txtIdData   = new JPTextBox(),
            txtIdTipoRiego = new JPTextBox(),
            txtHumedad   = new JPTextBox(),
            txtFechaCrea = new  JPTextBox(),
            txtFechaModifica = new JPTextBox();

    private JPButton 
            btnPageIni  = new JPButton(" |< "),
            btnPageAnt  = new JPButton(" << "),
            btnPageSig  = new JPButton(" >> "),
            btnPageFin  = new JPButton(" >| "),

            btnRowIni   = new JPButton(" |< "),
            btnRowAnt   = new JPButton(" << "),
            btnRowSig   = new JPButton(" >> "),
            btnRowFin   = new JPButton(" >| "),

            btnNuevo    = new JPButton("Nuevo"),
            btnGuardar  = new JPButton("Guardar"),
            btnCancelar = new JPButton("Cancelar"),
            btnEliminar = new JPButton("Eliminar");
    private JPanel 
            pnlTabla    = new JPanel(),
            pnlBtnRow   = new JPanel(new FlowLayout()),
            pnlBtnPage  = new JPanel(new FlowLayout()),
            pnlBtnCRUD  = new JPanel(new FlowLayout());

    public void customizeComponent() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        txtIdData.setEnabled(true);
        txtIdData.setBorderLine();
        txtHumedad.setBorderLine();

        pnlBtnPage.add(btnPageIni);
        pnlBtnPage.add(btnPageAnt);
        pnlBtnPage.add(new JPLabel(" Page:( "));
        pnlBtnPage.add(lblTotalReg); //cambiar
        pnlBtnPage.add(new JPLabel(" ) "));
        pnlBtnPage.add(btnPageSig);
        pnlBtnPage.add(btnPageFin);

        pnlBtnRow.add(btnRowIni);
        pnlBtnRow.add(btnRowAnt);
        pnlBtnRow.add(lblTotalReg);
        pnlBtnRow.add(btnRowSig);
        pnlBtnRow.add(btnRowFin);

        pnlBtnCRUD.add(btnNuevo);
        pnlBtnCRUD.add(btnGuardar);
        pnlBtnCRUD.add(btnCancelar);
        pnlBtnCRUD.add(btnEliminar);
        pnlBtnCRUD.setBorder(IAStyle.createBorderRect());

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridy = 0;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(lblTitulo, gbc);

        gbc.gridy = 1;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de datos: "), gbc);
        gbc.gridy = 1;
        gbc.gridx = 1;
        add(pnlBtnPage, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.ipady = 150;
        gbc.ipadx = 450;
        pnlTabla.add(new Label("Loading data..."));
        add(pnlTabla, gbc);

        gbc.ipady = 1;
        gbc.ipadx = 1;

        gbc.gridy = 3;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(50, 0, 0, 0);  // Ajusta el valor superior a 50
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(Box.createRigidArea(new Dimension(0, 0)), gbc);

        gbc.insets = new Insets(10, 0, 0, 0);  

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 1;
        add(new JLabel("■ Sección de registro: "), gbc);
        gbc.gridy = 4;
        gbc.gridx = 1;
        add(pnlBtnRow, gbc);

        gbc.gridy = 5;
        gbc.gridx = 0;
        add(lblIdDato, gbc);
        gbc.gridy = 5;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtIdData, gbc);

        gbc.gridy = 6;
        gbc.gridx = 0;
        add(lblHumedad, gbc);
        gbc.gridy = 6;
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = GridBagConstraints.REMAINDER; // Indica que este componente ocupa toda la fila
        add(txtHumedad, gbc);

        // gbc.gridy = 7;
        // gbc.gridx = 1;
        // gbc.gridwidth = 2;
        // gbc.fill = GridBagConstraints.HORIZONTAL;
        // add(pnlBtnRow, gbc);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(pnlBtnCRUD, gbc);
    }
}