/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package INTERFAZ;

import java.awt.CardLayout;
import javax.swing.*;
import java.sql.*;
import ACCESO_DATOS.controladores.*;
import ACCESO_DATOS.entidades_y_relaciones.*;
import Login.Encriptacion;
import java.util.ArrayList;

/**
 *
 * @author aleja_000
 */
public class GUIgerente extends javax.swing.JFrame {
    GUIlogin login;
    CardLayout card;
    CardLayout card2;
    CardLayout card3;
    CardLayout card4;
    CardLayout ventanaUsuarios;
    CardLayout ventanaInventario;
    CardLayout ventanaInventarioCrearVehiculo;
    CardLayout ventanaInventarioCrearRepuesto;
    CardLayout ventanaInventarioModificarVehiculo;
    CardLayout ventanaInventarioModificarRepuesto;
    /**
     * Creates new form AutosABC
     * @param login2
     */
    public GUIgerente(GUIlogin login2) {
        initComponents();
        login = login2;
        login.setVisible(false);
        card = new CardLayout();
        card2 = new CardLayout();
        card3 = new CardLayout();
        card4 = new CardLayout();
        ventanaUsuarios = new CardLayout();
        ventanaInventario = new CardLayout();
        ventanaInventarioCrearVehiculo = new CardLayout();
        ventanaInventarioCrearRepuesto = new CardLayout(); 
        ventanaInventarioModificarVehiculo = new CardLayout();
        ventanaInventarioModificarRepuesto = new CardLayout();
                
        card.addLayoutComponent(panelGerente, "panelGerente");
        
        card2.addLayoutComponent(panelSedeGerente, "SEDES");
        card2.addLayoutComponent(panelUsuariosGerente, "USUARIOS");
        card2.addLayoutComponent(panelInventarioGerente, "INVENTARIO");
        card2.addLayoutComponent(panelReportesGerente, "REPORTES");
        
        card3.addLayoutComponent(panelConsultarSede, "CONSULTAR-SEDE");
        card3.addLayoutComponent(panelModificarSede, "MODIFICAR-SEDE");
        card3.addLayoutComponent(panelCrearSede, "CREAR-SEDE");
        
        card4.addLayoutComponent(panelSedeConsultaFiltroOFF, "SIN-FILTRO");
        card4.addLayoutComponent(panelSedeConsultaFiltroON, "CON-FILTRO");
        
        ventanaUsuarios.addLayoutComponent(panelCrearUsuario,"CREAR-USUARIO");
        ventanaUsuarios.addLayoutComponent(panelModificarUsuario,"MODIFICAR-USUARIO");
        
        ventanaInventario.addLayoutComponent(panelCrearInventario,"CREAR-INVENTARIO");
        ventanaInventario.addLayoutComponent(panelModificarInventario,"MODIFICAR-INVENTARIO");
        
        ventanaInventarioCrearVehiculo.addLayoutComponent(panelCrearInventarioCrearVehiculo,"CREAR-VEHICULO-MOSTRAR");
        ventanaInventarioCrearVehiculo.addLayoutComponent(panelCrearInventarioCrearVehiculoVacio,"CREAR-VEHICULO-OCULTAR");
        
        ventanaInventarioCrearRepuesto.addLayoutComponent(panelCrearInventarioCrearRepuesto,"CREAR-REPUESTO-MOSTRAR");
        ventanaInventarioCrearRepuesto.addLayoutComponent(panelCrearInventarioCrearRepuestoVacio,"CREAR-REPUESTO-OCULTAR");
        
        ventanaInventarioModificarVehiculo.addLayoutComponent(panelModificarInventarioModificarVehiculo,"MODIFICAR-VEHICULO-MOSTRAR");
        ventanaInventarioModificarVehiculo.addLayoutComponent(panelModificarInventarioModificarVehiculoVacio,"MODIFICAR-VEHICULO-OCULTAR");
        
        ventanaInventarioModificarRepuesto.addLayoutComponent(panelModificarInventarioModificarRepuesto,"MODIFICAR-REPUESTO-MOSTRAR");
        ventanaInventarioModificarRepuesto.addLayoutComponent(panelModificarInventarioModificarRepuestoVacio,"MODIFICAR-REPUESTO-OCULTAR");
        
        
        
        jPanel3.setLayout(card2);
        jPanel9.setLayout(card3);
        jPanel14.setLayout(card4);
        jPanel11.setLayout(ventanaUsuarios);
        jPanel13.setLayout(ventanaInventario);
        jPanel7.setLayout(ventanaInventarioCrearVehiculo);
        jPanel15.setLayout(ventanaInventarioCrearRepuesto);
        jPanel16.setLayout(ventanaInventarioModificarVehiculo);
        jPanel17.setLayout(ventanaInventarioModificarRepuesto);
        
        jPanel3.add(panelSedeGerente);
        jPanel3.add(panelUsuariosGerente);
        jPanel3.add(panelInventarioGerente);
        jPanel3.add(panelReportesGerente);
        
        jPanel9.add(panelConsultarSede);
        jPanel9.add(panelModificarSede);
        jPanel9.add(panelCrearSede);
        
        jPanel14.add(panelSedeConsultaFiltroON);
        jPanel14.add(panelSedeConsultaFiltroOFF);
        
        jPanel11.add(panelCrearUsuario);
        jPanel11.add(panelModificarUsuario);
        
        jPanel13.add(panelCrearInventario);
        jPanel13.add(panelModificarInventario);
        
        jPanel7.add(panelCrearInventarioCrearVehiculo);
        jPanel7.add(panelCrearInventarioCrearVehiculoVacio);
        
        jPanel15.add(panelCrearInventarioCrearRepuesto);
        jPanel15.add(panelCrearInventarioCrearRepuestoVacio);
        
        jPanel16.add(panelModificarInventarioModificarVehiculo);
        jPanel16.add(panelModificarInventarioModificarVehiculoVacio);
        
        jPanel17.add(panelModificarInventarioModificarRepuesto);
        jPanel17.add(panelModificarInventarioModificarRepuestoVacio);

        getContentPane().setLayout(card);
        getContentPane().add(panelGerente);
        panelGerente.setBounds(0,0,737,522);
        setBounds(panelGerente.getBounds());
        card.show(getContentPane(), "panelGerente");
        
        setVisible(true);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGerente = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        botonSedesGerente = new javax.swing.JButton();
        botonUsuariosGerente = new javax.swing.JButton();
        botonReportesGerente = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        botonInventarioGerente = new javax.swing.JButton();
        panelSedeGerente = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        panelUsuariosGerente = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        botonCrearUsuario = new javax.swing.JButton();
        botonModificarUsuario = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        panelInventarioGerente = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        botonCrearInventario = new javax.swing.JButton();
        botonModificarInventario = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        panelReportesGerente = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        panelConsultarSede = new javax.swing.JPanel();
        seleccionarSede = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        seleccionFiltroSede = new javax.swing.JComboBox<>();
        jButton8 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel14 = new javax.swing.JPanel();
        panelModificarSede = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        panelCrearSede = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonCrearSede = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        fax_sede = new javax.swing.JTextField();
        telefono_sede = new javax.swing.JTextField();
        dir_sede = new javax.swing.JTextField();
        ciudad_sede = new javax.swing.JTextField();
        nombre_sede = new javax.swing.JTextField();
        id_sede = new javax.swing.JTextField();
        panelSedeConsultaFiltroOFF = new javax.swing.JPanel();
        panelSedeConsultaFiltroON = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        panelCrearUsuario = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        nombre_usuario = new javax.swing.JTextField();
        cedula_usuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        radioBotonGeneroM = new javax.swing.JRadioButton();
        radioBotonGeneroF = new javax.swing.JRadioButton();
        nacimiento_usuario = new javax.swing.JTextField();
        email_usuario = new javax.swing.JTextField();
        cuenta_usuario = new javax.swing.JTextField();
        comboBoxCargoUsuario = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        direccion_usuario = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        telefono_usuario = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        salario_usuario = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        contrasena_usuario = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        comboBoxSedeCrearUsuario = new javax.swing.JComboBox<>();
        botonAyudaCrearUsuario = new javax.swing.JButton();
        botonCrearUsuarioConfirmacion = new javax.swing.JButton();
        panelModificarUsuario = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField17 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        botonAyudaCrearUsuario1 = new javax.swing.JButton();
        panelCrearInventario = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        botonPanelInventarioCrearVehiculo = new javax.swing.JButton();
        botonPanelInventarioCrearRepuesto = new javax.swing.JButton();
        botonAñadirVehiculo = new javax.swing.JButton();
        botonAñadirRepuesto = new javax.swing.JButton();
        panelModificarInventario = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        panelCrearInventarioCrearVehiculo = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        marca_vehiculo = new javax.swing.JTextField();
        referencia_vehiculo = new javax.swing.JTextField();
        modelo_vehiculo = new javax.swing.JTextField();
        precio_vehiculo = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        color_vehiculo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cantidad_vehiculo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        comboBoxTipoVehiculo = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        comboBoxTraccionVehiculo = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        comboBoxSedeVehiculosInventario = new javax.swing.JComboBox<>();
        panelCrearInventarioCrearRepuesto = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        nombre_repuesto = new javax.swing.JTextField();
        cantidad_repuesto = new javax.swing.JTextField();
        precio_repuesto = new javax.swing.JTextField();
        descripcion_repuesto = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        comboBoxSedeRepuestosInventario = new javax.swing.JComboBox<>();
        jLabel39 = new javax.swing.JLabel();
        comboBoxRepuestoVehiculo = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        botonAñadirRepuestoVehiculo = new javax.swing.JButton();
        panelCrearInventarioCrearVehiculoVacio = new javax.swing.JPanel();
        panelCrearInventarioCrearRepuestoVacio = new javax.swing.JPanel();
        panelModificarInventarioModificarVehiculo = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jButton19 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        jTextField40 = new javax.swing.JTextField();
        panelModificarInventarioModificarRepuesto = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        panelModificarInventarioModificarVehiculoVacio = new javax.swing.JPanel();
        panelModificarInventarioModificarRepuestoVacio = new javax.swing.JPanel();

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 713, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        botonSedesGerente.setText("SEDES");
        botonSedesGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSedesGerenteActionPerformed(evt);
            }
        });

        botonUsuariosGerente.setText("USUARIOS");
        botonUsuariosGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosGerenteActionPerformed(evt);
            }
        });

        botonReportesGerente.setText("REPORTES");
        botonReportesGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReportesGerenteActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono-logout.png"))); // NOI18N
        jButton6.setToolTipText("Presione aqui para salir a la ventana de Login");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        botonInventarioGerente.setText("INVENTARIO");
        botonInventarioGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonInventarioGerenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonSedesGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonUsuariosGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonInventarioGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botonReportesGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botonSedesGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonUsuariosGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonInventarioGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonReportesGerente, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelGerenteLayout = new javax.swing.GroupLayout(panelGerente);
        panelGerente.setLayout(panelGerenteLayout);
        panelGerenteLayout.setHorizontalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelGerenteLayout.setVerticalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelSedeGerente.setPreferredSize(new java.awt.Dimension(717, 388));

        jPanel8.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CREAR-SEDE.png"))); // NOI18N
        jButton11.setToolTipText("Al hacer click en este boton, se desplegará  el menu para crear sedes");
        jButton11.setAutoscrolls(true);
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/MODIFICAR-SEDE.png"))); // NOI18N
        jButton12.setToolTipText("Al hacer click en este boton, se desplegará  el menu para modificar sedes");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CONSULTAR-SEDE.png"))); // NOI18N
        jButton15.setToolTipText("Al hacer click en este boton, se desplegará  el menu para hacer consultas de la base de datos de la empresa");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelSedeGerenteLayout = new javax.swing.GroupLayout(panelSedeGerente);
        panelSedeGerente.setLayout(panelSedeGerenteLayout);
        panelSedeGerenteLayout.setHorizontalGroup(
            panelSedeGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSedeGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSedeGerenteLayout.setVerticalGroup(
            panelSedeGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSedeGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSedeGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelUsuariosGerente.setPreferredSize(new java.awt.Dimension(717, 388));

        jPanel10.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CREAR-USUARIO.png"))); // NOI18N
        botonCrearUsuario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para crear usuarios");
        botonCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearUsuarioActionPerformed(evt);
            }
        });

        botonModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/MODIFICAR-USUARIO.png"))); // NOI18N
        botonModificarUsuario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para modificar usuarios");
        botonModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(botonModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelUsuariosGerenteLayout = new javax.swing.GroupLayout(panelUsuariosGerente);
        panelUsuariosGerente.setLayout(panelUsuariosGerenteLayout);
        panelUsuariosGerenteLayout.setHorizontalGroup(
            panelUsuariosGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUsuariosGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelUsuariosGerenteLayout.setVerticalGroup(
            panelUsuariosGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUsuariosGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelUsuariosGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelInventarioGerente.setPreferredSize(new java.awt.Dimension(717, 388));

        jPanel12.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonCrearInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/CREAR-INVENTARIO.png"))); // NOI18N
        botonCrearInventario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para crear vehiculos o repuestos");
        botonCrearInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearInventarioActionPerformed(evt);
            }
        });

        botonModificarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/MODIFICAR-INVENTARIO.png"))); // NOI18N
        botonModificarInventario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para modificar vehiculos o repuestos");
        botonModificarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonModificarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonCrearInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(botonModificarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 584, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelInventarioGerenteLayout = new javax.swing.GroupLayout(panelInventarioGerente);
        panelInventarioGerente.setLayout(panelInventarioGerenteLayout);
        panelInventarioGerenteLayout.setHorizontalGroup(
            panelInventarioGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInventarioGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelInventarioGerenteLayout.setVerticalGroup(
            panelInventarioGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInventarioGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInventarioGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelReportesGerente.setPreferredSize(new java.awt.Dimension(717, 388));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono-construccion.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelReportesGerenteLayout = new javax.swing.GroupLayout(panelReportesGerente);
        panelReportesGerente.setLayout(panelReportesGerenteLayout);
        panelReportesGerenteLayout.setHorizontalGroup(
            panelReportesGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelReportesGerenteLayout.setVerticalGroup(
            panelReportesGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelConsultarSede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelConsultarSede.setPreferredSize(new java.awt.Dimension(586, 366));

        seleccionarSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Inventario", "Informacion", "Usuarios", "Ordenes Taller" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        seleccionFiltroSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Filtro", "Una sede", "Todas las sedes" }));
        seleccionFiltroSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seleccionFiltroSedeActionPerformed(evt);
            }
        });

        jButton8.setText("CONSULTAR");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelConsultarSedeLayout = new javax.swing.GroupLayout(panelConsultarSede);
        panelConsultarSede.setLayout(panelConsultarSedeLayout);
        panelConsultarSedeLayout.setHorizontalGroup(
            panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                        .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                                .addComponent(seleccionarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(seleccionFiltroSede, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConsultarSedeLayout.setVerticalGroup(
            panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelConsultarSedeLayout.createSequentialGroup()
                        .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seleccionarSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(seleccionFiltroSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelModificarSede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelModificarSede.setPreferredSize(new java.awt.Dimension(586, 366));

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel11.setText("NOMBRE SEDE:");

        jLabel12.setText("NUEVO NOMBRE:");

        jLabel13.setText("NUEVO TELEFONO");

        jLabel14.setText("NUEVO FAX");

        javax.swing.GroupLayout panelModificarSedeLayout = new javax.swing.GroupLayout(panelModificarSede);
        panelModificarSede.setLayout(panelModificarSedeLayout);
        panelModificarSedeLayout.setHorizontalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField5))
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField2))
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField3))
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField4)))
                .addContainerGap())
        );
        panelModificarSedeLayout.setVerticalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarSedeLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelCrearSede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelCrearSede.setPreferredSize(new java.awt.Dimension(586, 366));
        panelCrearSede.setRequestFocusEnabled(false);
        panelCrearSede.setVerifyInputWhenFocusTarget(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("IDENTIFICACIÓN:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("NOMBRE:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("CIUDAD:");
        jLabel7.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("DIRECCION:");
        jLabel8.setToolTipText("");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("TELEFONO:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("FAX:");

        botonCrearSede.setText("CREAR");
        botonCrearSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearSedeActionPerformed(evt);
            }
        });

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono ayuda.jpg"))); // NOI18N
        jButton14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton14.setName(""); // NOI18N
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        dir_sede.setToolTipText("");

        ciudad_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciudad_sedeActionPerformed(evt);
            }
        });

        id_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_sedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearSedeLayout = new javax.swing.GroupLayout(panelCrearSede);
        panelCrearSede.setLayout(panelCrearSedeLayout);
        panelCrearSedeLayout.setHorizontalGroup(
            panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearSedeLayout.createSequentialGroup()
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 410, Short.MAX_VALUE)
                        .addComponent(botonCrearSede, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCrearSedeLayout.createSequentialGroup()
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(36, 36, 36)
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telefono_sede)
                            .addComponent(fax_sede)))
                    .addGroup(panelCrearSedeLayout.createSequentialGroup()
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dir_sede)
                            .addComponent(ciudad_sede)
                            .addComponent(nombre_sede)
                            .addComponent(id_sede))))
                .addContainerGap())
        );
        panelCrearSedeLayout.setVerticalGroup(
            panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(id_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ciudad_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(dir_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(telefono_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(fax_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addGroup(panelCrearSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelSedeConsultaFiltroOFF.setPreferredSize(new java.awt.Dimension(389, 30));

        javax.swing.GroupLayout panelSedeConsultaFiltroOFFLayout = new javax.swing.GroupLayout(panelSedeConsultaFiltroOFF);
        panelSedeConsultaFiltroOFF.setLayout(panelSedeConsultaFiltroOFFLayout);
        panelSedeConsultaFiltroOFFLayout.setHorizontalGroup(
            panelSedeConsultaFiltroOFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );
        panelSedeConsultaFiltroOFFLayout.setVerticalGroup(
            panelSedeConsultaFiltroOFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        panelSedeConsultaFiltroON.setPreferredSize(new java.awt.Dimension(389, 30));

        jLabel4.setText("IDENTIFICACION SEDE:");

        javax.swing.GroupLayout panelSedeConsultaFiltroONLayout = new javax.swing.GroupLayout(panelSedeConsultaFiltroON);
        panelSedeConsultaFiltroON.setLayout(panelSedeConsultaFiltroONLayout);
        panelSedeConsultaFiltroONLayout.setHorizontalGroup(
            panelSedeConsultaFiltroONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSedeConsultaFiltroONLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelSedeConsultaFiltroONLayout.setVerticalGroup(
            panelSedeConsultaFiltroONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSedeConsultaFiltroONLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelSedeConsultaFiltroONLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        panelCrearUsuario.setPreferredSize(new java.awt.Dimension(586, 366));

        jLabel15.setText("NOMBRE:");

        jLabel16.setText("CEDULA:");

        jLabel17.setText("FECHA DE NACIMIENTO:");

        jLabel18.setText("E-MAIL: ");

        jLabel19.setText("CARGO:");

        jLabel20.setText("USUARIO");

        nombre_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombre_usuarioActionPerformed(evt);
            }
        });

        jLabel21.setText("GENERO:");

        radioBotonGeneroM.setText("MASCULINO");
        radioBotonGeneroM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonGeneroMActionPerformed(evt);
            }
        });

        radioBotonGeneroF.setText("FEMENINO");
        radioBotonGeneroF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonGeneroFActionPerformed(evt);
            }
        });

        comboBoxCargoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una", "Gerente", "Jefe de Taller", "Vendedor" }));

        jLabel22.setText("DIRECCION:");

        jLabel23.setText("TELEFONO:");

        jLabel24.setText("SALARIO:");

        jLabel26.setText("CONTRASEÑA: ");

        jLabel27.setText("SEDE:");

        comboBoxSedeCrearUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        botonAyudaCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono ayuda.jpg"))); // NOI18N
        botonAyudaCrearUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAyudaCrearUsuario.setName(""); // NOI18N
        botonAyudaCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaCrearUsuarioActionPerformed(evt);
            }
        });

        botonCrearUsuarioConfirmacion.setText("CREAR USUARIO");
        botonCrearUsuarioConfirmacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearUsuarioConfirmacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearUsuarioLayout = new javax.swing.GroupLayout(panelCrearUsuario);
        panelCrearUsuario.setLayout(panelCrearUsuarioLayout);
        panelCrearUsuarioLayout.setHorizontalGroup(
            panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(email_usuario))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(nacimiento_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(direccion_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(comboBoxCargoUsuario, 0, 183, Short.MAX_VALUE)
                            .addComponent(salario_usuario))
                        .addGap(18, 18, 18)
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(23, 23, 23)
                                .addComponent(telefono_usuario))
                            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(radioBotonGeneroM)
                                .addGap(34, 34, 34)
                                .addComponent(radioBotonGeneroF)
                                .addGap(17, 17, 17))))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addComponent(botonAyudaCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(348, 348, 348)
                        .addComponent(botonCrearUsuarioConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cuenta_usuario))
                            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboBoxSedeCrearUsuario, 0, 196, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(contrasena_usuario))
                    .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cedula_usuario)
                            .addComponent(nombre_usuario))))
                .addContainerGap())
        );
        panelCrearUsuarioLayout.setVerticalGroup(
            panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nombre_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(cedula_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(nacimiento_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(direccion_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(email_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(comboBoxCargoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23)
                    .addComponent(telefono_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(salario_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21)
                    .addComponent(radioBotonGeneroM)
                    .addComponent(radioBotonGeneroF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(cuenta_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26)
                    .addComponent(contrasena_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(comboBoxSedeCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                .addGroup(panelCrearUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(botonAyudaCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearUsuarioConfirmacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelModificarUsuario.setPreferredSize(new java.awt.Dimension(586, 366));

        jLabel29.setText("Cedula del Usuario");

        jLabel30.setText("NUEVOS VALORES DEL USUARIO:");

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        jLabel32.setText("NUEVO VALOR:");

        jLabel31.setText("VALOR A MODIFICAR: ");

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Atributo", "Nombre", "Direccion", "E-mail", "Telefono", "Celular", "Sede", "Situacion Sentimental", "Usuario", "Contraseña" }));
        jComboBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox5ActionPerformed(evt);
            }
        });

        jButton10.setText("MODIFICAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextField17))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextField17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        botonAyudaCrearUsuario1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono ayuda.jpg"))); // NOI18N
        botonAyudaCrearUsuario1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAyudaCrearUsuario1.setName(""); // NOI18N
        botonAyudaCrearUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaCrearUsuario1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarUsuarioLayout = new javax.swing.GroupLayout(panelModificarUsuario);
        panelModificarUsuario.setLayout(panelModificarUsuarioLayout);
        panelModificarUsuarioLayout.setHorizontalGroup(
            panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(botonAyudaCrearUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelModificarUsuarioLayout.setVerticalGroup(
            panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jTextField16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(botonAyudaCrearUsuario1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelCrearInventario.setPreferredSize(new java.awt.Dimension(586, 366));

        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel15.setPreferredSize(new java.awt.Dimension(258, 276));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 311, Short.MAX_VALUE)
        );

        botonPanelInventarioCrearVehiculo.setText("VEHICULOS");
        botonPanelInventarioCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPanelInventarioCrearVehiculoActionPerformed(evt);
            }
        });

        botonPanelInventarioCrearRepuesto.setText("REPUESTOS");
        botonPanelInventarioCrearRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPanelInventarioCrearRepuestoActionPerformed(evt);
            }
        });

        botonAñadirVehiculo.setText("AÑADIR");
        botonAñadirVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirVehiculoActionPerformed(evt);
            }
        });

        botonAñadirRepuesto.setText("AÑADIR");
        botonAñadirRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirRepuestoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearInventarioLayout = new javax.swing.GroupLayout(panelCrearInventario);
        panelCrearInventario.setLayout(panelCrearInventarioLayout);
        panelCrearInventarioLayout.setHorizontalGroup(
            panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCrearInventarioLayout.createSequentialGroup()
                        .addComponent(botonPanelInventarioCrearVehiculo)
                        .addGap(94, 94, 94)
                        .addComponent(botonAñadirVehiculo))
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearInventarioLayout.createSequentialGroup()
                        .addComponent(botonAñadirRepuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botonPanelInventarioCrearRepuesto)))
                .addContainerGap())
        );
        panelCrearInventarioLayout.setVerticalGroup(
            panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonPanelInventarioCrearVehiculo)
                    .addComponent(botonPanelInventarioCrearRepuesto)
                    .addComponent(botonAñadirVehiculo)
                    .addComponent(botonAñadirRepuesto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 315, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelModificarInventario.setPreferredSize(new java.awt.Dimension(586, 366));

        jPanel16.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 254, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );

        jPanel17.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        jPanel17.setPreferredSize(new java.awt.Dimension(258, 276));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 263, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton9.setText("VEHICULOS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton16.setText("REPUESTOS");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton16)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton16))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelModificarInventarioLayout = new javax.swing.GroupLayout(panelModificarInventario);
        panelModificarInventario.setLayout(panelModificarInventarioLayout);
        panelModificarInventarioLayout.setHorizontalGroup(
            panelModificarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelModificarInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelModificarInventarioLayout.createSequentialGroup()
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelModificarInventarioLayout.setVerticalGroup(
            panelModificarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelModificarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelCrearInventarioCrearVehiculo.setPreferredSize(new java.awt.Dimension(267, 315));
        panelCrearInventarioCrearVehiculo.setRequestFocusEnabled(false);

        jLabel35.setText("MARCA:");

        jLabel36.setText("REFERENCIA:");

        jLabel37.setText("MODELO:");

        jLabel38.setText("PRECIO:");

        jLabel1.setText("COLOR: ");

        jLabel2.setText("CANTIDAD:");

        jLabel3.setText("TIPO:");

        comboBoxTipoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una", "Sedan", "Coupe" }));

        jLabel25.setText("TRACCION:");

        comboBoxTraccionVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una", "Delantera", "Trasera", "Doble" }));

        jLabel28.setText("SEDE:");

        comboBoxSedeVehiculosInventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout panelCrearInventarioCrearVehiculoLayout = new javax.swing.GroupLayout(panelCrearInventarioCrearVehiculo);
        panelCrearInventarioCrearVehiculo.setLayout(panelCrearInventarioCrearVehiculoLayout);
        panelCrearInventarioCrearVehiculoLayout.setHorizontalGroup(
            panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioCrearVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCrearInventarioCrearVehiculoLayout.createSequentialGroup()
                        .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel36)
                            .addComponent(jLabel35))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(marca_vehiculo)
                            .addComponent(referencia_vehiculo)))
                    .addGroup(panelCrearInventarioCrearVehiculoLayout.createSequentialGroup()
                        .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel38)
                            .addComponent(jLabel37)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel25)
                            .addComponent(jLabel28))
                        .addGap(21, 21, 21)
                        .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboBoxTraccionVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cantidad_vehiculo)
                            .addComponent(modelo_vehiculo)
                            .addComponent(precio_vehiculo)
                            .addComponent(color_vehiculo)
                            .addComponent(comboBoxTipoVehiculo, 0, 169, Short.MAX_VALUE)
                            .addComponent(comboBoxSedeVehiculosInventario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelCrearInventarioCrearVehiculoLayout.setVerticalGroup(
            panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioCrearVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(marca_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(referencia_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(modelo_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(precio_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(color_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cantidad_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboBoxTipoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(comboBoxTraccionVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(comboBoxSedeVehiculosInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );

        panelCrearInventarioCrearVehiculo.getAccessibleContext().setAccessibleName("");

        panelCrearInventarioCrearRepuesto.setName(""); // NOI18N
        panelCrearInventarioCrearRepuesto.setPreferredSize(new java.awt.Dimension(267, 315));

        jLabel40.setText("INFORMACION REPUESTO:");

        jLabel42.setText("NOMBRE:");

        jLabel43.setText("CANTIDAD:");

        jLabel44.setText("PRECIO UNIDAD:");

        jLabel45.setText("DESCRIPCION:");

        jLabel34.setText("SEDE:");

        comboBoxSedeRepuestosInventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel39.setText("INSERTE VEHICULO:");

        comboBoxRepuestoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        botonAñadirRepuestoVehiculo.setText("AÑADIR VEHICULO");
        botonAñadirRepuestoVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAñadirRepuestoVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelCrearInventarioCrearRepuestoLayout = new javax.swing.GroupLayout(panelCrearInventarioCrearRepuesto);
        panelCrearInventarioCrearRepuesto.setLayout(panelCrearInventarioCrearRepuestoLayout);
        panelCrearInventarioCrearRepuestoLayout.setHorizontalGroup(
            panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                        .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34)
                            .addComponent(jLabel42))
                        .addGap(49, 49, 49)
                        .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nombre_repuesto)
                            .addComponent(comboBoxSedeRepuestosInventario, 0, 152, Short.MAX_VALUE)))
                    .addGroup(panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                        .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44)
                            .addComponent(jLabel43)
                            .addComponent(jLabel45))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descripcion_repuesto)
                            .addComponent(cantidad_repuesto)
                            .addComponent(precio_repuesto)))
                    .addGroup(panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel39)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxRepuestoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel40)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonAñadirRepuestoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        panelCrearInventarioCrearRepuestoLayout.setVerticalGroup(
            panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCrearInventarioCrearRepuestoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel40)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(comboBoxSedeRepuestosInventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(nombre_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(cantidad_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(precio_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(descripcion_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelCrearInventarioCrearRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(comboBoxRepuestoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAñadirRepuestoVehiculo)
                .addContainerGap())
        );

        panelCrearInventarioCrearVehiculoVacio.setOpaque(false);
        panelCrearInventarioCrearVehiculoVacio.setPreferredSize(new java.awt.Dimension(267, 315));

        javax.swing.GroupLayout panelCrearInventarioCrearVehiculoVacioLayout = new javax.swing.GroupLayout(panelCrearInventarioCrearVehiculoVacio);
        panelCrearInventarioCrearVehiculoVacio.setLayout(panelCrearInventarioCrearVehiculoVacioLayout);
        panelCrearInventarioCrearVehiculoVacioLayout.setHorizontalGroup(
            panelCrearInventarioCrearVehiculoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        panelCrearInventarioCrearVehiculoVacioLayout.setVerticalGroup(
            panelCrearInventarioCrearVehiculoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 315, Short.MAX_VALUE)
        );

        panelCrearInventarioCrearRepuestoVacio.setName(""); // NOI18N
        panelCrearInventarioCrearRepuestoVacio.setPreferredSize(new java.awt.Dimension(267, 315));

        javax.swing.GroupLayout panelCrearInventarioCrearRepuestoVacioLayout = new javax.swing.GroupLayout(panelCrearInventarioCrearRepuestoVacio);
        panelCrearInventarioCrearRepuestoVacio.setLayout(panelCrearInventarioCrearRepuestoVacioLayout);
        panelCrearInventarioCrearRepuestoVacioLayout.setHorizontalGroup(
            panelCrearInventarioCrearRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        panelCrearInventarioCrearRepuestoVacioLayout.setVerticalGroup(
            panelCrearInventarioCrearRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        panelModificarInventarioModificarVehiculo.setPreferredSize(new java.awt.Dimension(258, 276));

        jLabel60.setText("INFORMACION REPUESTO:");

        jLabel61.setText("ID:");

        jButton19.setText("MODIFICAR");

        jLabel62.setText("ATRIBUTO");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel63.setText("NUEVO VALOR:");

        javax.swing.GroupLayout panelModificarInventarioModificarVehiculoLayout = new javax.swing.GroupLayout(panelModificarInventarioModificarVehiculo);
        panelModificarInventarioModificarVehiculo.setLayout(panelModificarInventarioModificarVehiculoLayout);
        panelModificarInventarioModificarVehiculoLayout.setHorizontalGroup(
            panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField39))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton19))
                            .addComponent(jLabel60))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField40)))
                .addContainerGap())
        );
        panelModificarInventarioModificarVehiculoLayout.setVerticalGroup(
            panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(jTextField40, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton19)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        panelModificarInventarioModificarRepuesto.setPreferredSize(new java.awt.Dimension(258, 276));

        jLabel52.setText("INFORMACION REPUESTO:");

        jLabel53.setText("ID:");

        jButton18.setText("MODIFICAR");

        jLabel58.setText("ATIRBUTO");

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel59.setText("NUEVO VALOR:");

        javax.swing.GroupLayout panelModificarInventarioModificarRepuestoLayout = new javax.swing.GroupLayout(panelModificarInventarioModificarRepuesto);
        panelModificarInventarioModificarRepuesto.setLayout(panelModificarInventarioModificarRepuestoLayout);
        panelModificarInventarioModificarRepuestoLayout.setHorizontalGroup(
            panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField33))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jButton18))
                            .addComponent(jLabel52))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField38)))
                .addContainerGap())
        );
        panelModificarInventarioModificarRepuestoLayout.setVerticalGroup(
            panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel53)
                    .addComponent(jTextField33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jButton18)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        panelModificarInventarioModificarVehiculoVacio.setPreferredSize(new java.awt.Dimension(258, 276));

        javax.swing.GroupLayout panelModificarInventarioModificarVehiculoVacioLayout = new javax.swing.GroupLayout(panelModificarInventarioModificarVehiculoVacio);
        panelModificarInventarioModificarVehiculoVacio.setLayout(panelModificarInventarioModificarVehiculoVacioLayout);
        panelModificarInventarioModificarVehiculoVacioLayout.setHorizontalGroup(
            panelModificarInventarioModificarVehiculoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 258, Short.MAX_VALUE)
        );
        panelModificarInventarioModificarVehiculoVacioLayout.setVerticalGroup(
            panelModificarInventarioModificarVehiculoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        panelModificarInventarioModificarRepuestoVacio.setPreferredSize(new java.awt.Dimension(258, 276));

        javax.swing.GroupLayout panelModificarInventarioModificarRepuestoVacioLayout = new javax.swing.GroupLayout(panelModificarInventarioModificarRepuestoVacio);
        panelModificarInventarioModificarRepuestoVacio.setLayout(panelModificarInventarioModificarRepuestoVacioLayout);
        panelModificarInventarioModificarRepuestoVacioLayout.setHorizontalGroup(
            panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        panelModificarInventarioModificarRepuestoVacioLayout.setVerticalGroup(
            panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("AUTOS ABC -- GERENTE");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        setBounds(0, 0, 619, 432);
    }// </editor-fold>//GEN-END:initComponents
    
    private void botonSedesGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSedesGerenteActionPerformed
        card2.show(jPanel3, "SEDES");
        card3.show(jPanel9, "CREAR-SEDE");
    }//GEN-LAST:event_botonSedesGerenteActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        card3.show(jPanel9, "CREAR-SEDE");

    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        card3.show(jPanel9, "CONSULTAR-SEDE");
        
        seleccionarSede.removeAllItems();
        seleccionarSede.addItem("Selecione una sede");
      
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        card3.show(jPanel9, "MODIFICAR-SEDE");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void botonUsuariosGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosGerenteActionPerformed
        card2.show(jPanel3, "USUARIOS");
        
        comboBoxSedeCrearUsuario.removeAllItems();
        comboBoxSedeCrearUsuario.addItem("Seleccione una");

        ControladorSede cSede = new ControladorSede();

        ArrayList<Sede> sedes = cSede.consultarSedes();

        for (int i = 0; i < sedes.size(); i++) {
            comboBoxSedeCrearUsuario.addItem(sedes.get(i).getNombre());
        }
    }//GEN-LAST:event_botonUsuariosGerenteActionPerformed

    private void botonReportesGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReportesGerenteActionPerformed
        card2.show(jPanel3, "REPORTES");
    }//GEN-LAST:event_botonReportesGerenteActionPerformed

    private void id_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_sedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_sedeActionPerformed

    private void ciudad_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciudad_sedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciudad_sedeActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Aqui va un texto de ayuda");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void botonCrearSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearSedeActionPerformed
        try {
            
            int sede_id = Integer.parseInt(id_sede.getText());
            String nombre = nombre_sede.getText();
            String ciudad = ciudad_sede.getText();
            String direccion = dir_sede.getText();
            String telefono = Integer.toString(Integer.parseInt(telefono_sede.getText()));
            String fax = Integer.toString(Integer.parseInt(fax_sede.getText()));
            
            if(nombre.equals("") | ciudad.equals("") | direccion.equals("") | (sede_id <=0)){
                JOptionPane.showMessageDialog(rootPane, "DEBE LLENAR TODOS LOS CAMPOS, LA IDENTIFICACION DE LA SEDE \n"
                        + "NO PUEDE SER UN NUMERO NEGATIVO O CERO", "AutosABC", JOptionPane.ERROR_MESSAGE);
            }
            
            else {
                ControladorSede cSede = new ControladorSede();
        
                int result = cSede.insertarSede(
                        sede_id, 
                        nombre, 
                        ciudad, 
                        direccion, 
                        telefono, 
                        fax
                );

                if ((result == -2) | (result == -3)){
                    JOptionPane.showMessageDialog(rootPane, "    NO SE REGISTRO LA SEDE, \n HUBO UN PROBLEMA EN EL REGISTRO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(rootPane, "SEDE REGISTRADA CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
        
        catch(NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "LA IDENTIFICACION, EL TELEFONO Y EL FAZ DEBEN SER NUMEROS", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_botonCrearSedeActionPerformed

    private void seleccionFiltroSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seleccionFiltroSedeActionPerformed
        if (seleccionFiltroSede.getSelectedIndex() == 1) {
            card4.show(jPanel14, "CON-FILTRO");
        }
        
        else {
            
            card4.show(jPanel14, "SIN-FILTRO");
        }
    }//GEN-LAST:event_seleccionFiltroSedeActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
        login.setVisible(true);
        login.reset();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void botonCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearUsuarioActionPerformed
        ventanaUsuarios.show(jPanel11, "CREAR-USUARIO");
        comboBoxSedeCrearUsuario.removeAllItems();
        comboBoxSedeCrearUsuario.addItem("Seleccione una");

        ControladorSede cSede = new ControladorSede();

        ArrayList<Sede> sedes = cSede.consultarSedes();

        for (int i = 0; i < sedes.size(); i++) {
            comboBoxSedeCrearUsuario.addItem(sedes.get(i).getNombre());
        }
    }//GEN-LAST:event_botonCrearUsuarioActionPerformed

    private void botonModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarUsuarioActionPerformed
        ventanaUsuarios.show(jPanel11, "MODIFICAR-USUARIO");
    }//GEN-LAST:event_botonModificarUsuarioActionPerformed

    private void nombre_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombre_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombre_usuarioActionPerformed

    private void radioBotonGeneroMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonGeneroMActionPerformed
        radioBotonGeneroF.setSelected(false);
    }//GEN-LAST:event_radioBotonGeneroMActionPerformed
        
    private void botonAyudaCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaCrearUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAyudaCrearUsuarioActionPerformed

    private void jComboBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox5ActionPerformed

    private void botonAyudaCrearUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaCrearUsuario1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAyudaCrearUsuario1ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void botonInventarioGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonInventarioGerenteActionPerformed
       card2.show(jPanel3, "INVENTARIO");
       ventanaInventarioCrearVehiculo.show(jPanel7, "CREAR-VEHICULO-MOSTRAR");
       ventanaInventarioCrearRepuesto.show(jPanel15, "CREAR-REPUESTO-OCULTAR");
       
       comboBoxSedeVehiculosInventario.removeAllItems();
       comboBoxSedeRepuestosInventario.removeAllItems();
       comboBoxSedeVehiculosInventario.addItem("Seleccione una");
       comboBoxSedeRepuestosInventario.addItem("Seleccione una");
       
       ControladorSede cSede = new ControladorSede();
       
       ArrayList<Sede> sedes = cSede.consultarSedes();
       
       for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeVehiculosInventario.addItem(sedes.get(i).getNombre());
       }
       
       for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeRepuestosInventario.addItem(sedes.get(i).getNombre());
       }
       
       botonAñadirRepuesto.setEnabled(false);
       botonAñadirVehiculo.setEnabled(true);
       
    }//GEN-LAST:event_botonInventarioGerenteActionPerformed

    private void botonCrearInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearInventarioActionPerformed
        ventanaInventario.show(jPanel13, "CREAR-INVENTARIO");
        comboBoxSedeVehiculosInventario.removeAllItems();
        comboBoxSedeRepuestosInventario.removeAllItems();
        comboBoxSedeVehiculosInventario.addItem("Seleccione una");
        comboBoxSedeRepuestosInventario.addItem("Seleccione una");
       
        ControladorSede cSede = new ControladorSede();
       
        ArrayList<Sede> sedes = cSede.consultarSedes();
       
        for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeVehiculosInventario.addItem(sedes.get(i).getNombre());
        }
       
        for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeRepuestosInventario.addItem(sedes.get(i).getNombre());
        }
        
        botonAñadirRepuesto.setEnabled(false);
        botonAñadirVehiculo.setEnabled(true);
    }//GEN-LAST:event_botonCrearInventarioActionPerformed

    private void botonModificarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarInventarioActionPerformed
        ventanaInventario.show(jPanel13, "MODIFICAR-INVENTARIO");
        ventanaInventarioModificarVehiculo.show(jPanel16, "MODIFICAR-VEHICULO-MOSTRAR");
        ventanaInventarioModificarRepuesto.show(jPanel17, "MODIFICAR-REPUESTO-OCULTAR");
    }//GEN-LAST:event_botonModificarInventarioActionPerformed

    private void botonPanelInventarioCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPanelInventarioCrearVehiculoActionPerformed
        ventanaInventarioCrearRepuesto.show(jPanel15, "CREAR-REPUESTO-OCULTAR");
        ventanaInventarioCrearVehiculo.show(jPanel7, "CREAR-VEHICULO-MOSTRAR");
        comboBoxSedeVehiculosInventario.removeAllItems();
        comboBoxSedeRepuestosInventario.removeAllItems();
        comboBoxSedeVehiculosInventario.addItem("Seleccione una");
        comboBoxSedeRepuestosInventario.addItem("Seleccione una");

        ControladorSede cSede = new ControladorSede();

        ArrayList<Sede> sedes = cSede.consultarSedes();

        for (int i = 0; i < sedes.size(); i++) {
            comboBoxSedeVehiculosInventario.addItem(sedes.get(i).getNombre());
        }

        for (int i = 0; i < sedes.size(); i++) {
            comboBoxSedeRepuestosInventario.addItem(sedes.get(i).getNombre());
        }
        
        botonAñadirRepuesto.setEnabled(false);
        botonAñadirVehiculo.setEnabled(true);
    }//GEN-LAST:event_botonPanelInventarioCrearVehiculoActionPerformed

    private void botonPanelInventarioCrearRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonPanelInventarioCrearRepuestoActionPerformed
       ventanaInventarioCrearVehiculo.show(jPanel7, "CREAR-VEHICULO-OCULTAR");
       ventanaInventarioCrearRepuesto.show(jPanel15, "CREAR-REPUESTO-MOSTRAR");
       comboBoxSedeVehiculosInventario.removeAllItems();
       comboBoxSedeRepuestosInventario.removeAllItems();
       comboBoxSedeVehiculosInventario.addItem("Seleccione una");
       comboBoxSedeRepuestosInventario.addItem("Seleccione una");
       
       ControladorSede cSede = new ControladorSede();
       
       ArrayList<Sede> sedes = cSede.consultarSedes();
       
       for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeVehiculosInventario.addItem(sedes.get(i).getNombre());
       }
       
       for (int i = 0; i < sedes.size(); i++) {
           comboBoxSedeRepuestosInventario.addItem(sedes.get(i).getNombre());
       }
       
       botonAñadirRepuesto.setEnabled(true);
       botonAñadirVehiculo.setEnabled(false);
    }//GEN-LAST:event_botonPanelInventarioCrearRepuestoActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
       ventanaInventarioModificarVehiculo.show(jPanel16, "MODIFICAR-VEHICULO-MOSTRAR");
       ventanaInventarioModificarRepuesto.show(jPanel17, "MODIFICAR-REPUESTO-OCULTAR");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        ventanaInventarioModificarVehiculo.show(jPanel16, "MODIFICAR-VEHICULO-OCULTAR");
        ventanaInventarioModificarRepuesto.show(jPanel17, "MODIFICAR-REPUESTO-MOSTRAR");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void botonCrearUsuarioConfirmacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearUsuarioConfirmacionActionPerformed
        
        try {
            
            boolean enviar = true;
            int sede = comboBoxSedeCrearUsuario.getSelectedIndex();
            char genero = ' ';
            
            if (radioBotonGeneroM.isSelected()) {
                genero = 'M';
            }
            else if(radioBotonGeneroF.isSelected()){
                genero = 'F';
            }
            
            else {
                JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UN GENERO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                enviar = false;
            }
            
            int cedula = Integer.parseInt(cedula_usuario.getText());
            String nombre = nombre_usuario.getText();
            String direccion = direccion_usuario.getText();
            Date nacimiento = Date.valueOf(nacimiento_usuario.getText());
            int cargo = comboBoxCargoUsuario.getSelectedIndex();
            String telefono = Integer.toString(Integer.parseInt(telefono_usuario.getText()));
            int salario = Integer.parseInt(salario_usuario.getText());
            String usuario = cuenta_usuario.getText();
            String contrasena = contrasena_usuario.getText();
            String email = email_usuario.getText();
            String estado = "activo";

            if (enviar){
                if ((cedula <= 0) | nombre.equals("") | usuario.equals("") | contrasena.equals("") | direccion.equals("") | 
                        email.equals("") | (salario <= 0) | (sede == 0) | (cargo == 0)){
                    JOptionPane.showMessageDialog(
                            rootPane, 
                            "DEBE DIGITAR TODOS LOS CAMPOS, LOS CAMPOS NUMERICOS NO PUEDEN SER CERO O NEGATIVOS,"
                                    + "\n ADEMÁS RECUERDE SELECCIONAR UNA SEDE Y UN CARGO", 
                            "AutosABC", 
                            JOptionPane.ERROR_MESSAGE);
                }
                else {
                    ControladorSede cSede = new ControladorSede();

                    ArrayList<Sede> sedes = cSede.consultarSedes();

                    int id_sede_usuario = sedes.get(sede - 1).getId();

                    Sede sede_usuario = new Sede();

                    sede_usuario.setId(id_sede_usuario);

                    Encriptacion encripto = new Encriptacion();
                    
                    ArrayList<String> pesos_cuenta = encripto.encriptar(usuario);
                    ArrayList<String> pesos_contrasena = encripto.encriptar(contrasena);
                    
                    String PIN =  pesos_contrasena.get(1) + pesos_cuenta.get(1);

                    ControladorUsuario nuevoUsuario = new ControladorUsuario();
                    int result = nuevoUsuario.insertarUsuario(
                            cedula,
                            sede_usuario, 
                            nombre, 
                            nacimiento, 
                            direccion,
                            genero,
                            email,
                            cargo,
                            salario,
                            telefono,
                            estado,
                            pesos_cuenta.get(0),
                            pesos_contrasena.get(0)
                            );
                    
                    if((result == -2 )|(result == -3)){
                        JOptionPane.showMessageDialog(rootPane, "EL USUARIO NO SE HA REGISTRADO, HA OCURRIDO UN ERROR", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    
                    else {
                        JOptionPane.showMessageDialog(rootPane, "       USUARIO CREADO CON EXITO: \n"
                            + "EL PIN DEL USUARIO ES: " + PIN, "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        }
        
        catch(NumberFormatException e){
             JOptionPane.showMessageDialog(rootPane, "LA CEDULA, EL SALARIO Y EL TELEFONO DEBEN SER NUMEROS", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        catch(IllegalArgumentException e){
             JOptionPane.showMessageDialog(rootPane, "LA FECHA DE NACIMIENTO DEBE TENER EL FORMATO 'AAAA-MM-DD'", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_botonCrearUsuarioConfirmacionActionPerformed

    private void botonAñadirVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirVehiculoActionPerformed
       try {
           int precio = Integer.parseInt(precio_vehiculo.getText());      
           int cantidad = Integer.parseInt(cantidad_vehiculo.getText());
           int iva =  precio*(16/100);
           String color = color_vehiculo.getText();
           String marca = marca_vehiculo.getText();
           String referencia = referencia_vehiculo.getText();
           String modelo = modelo_vehiculo.getText();
           String tipo = comboBoxTipoVehiculo.getSelectedItem().toString();
           String traccion = comboBoxTraccionVehiculo.getSelectedItem().toString();
           int sede = comboBoxSedeVehiculosInventario.getSelectedIndex();          
                      
           if((color.equals("")) | (marca.equals("")) | (referencia.equals("")) | (modelo.equals("")) | (sede == 0) | (tipo.equalsIgnoreCase("seleccione una")) | (traccion.equalsIgnoreCase("seleccione una")) | (cantidad <= 0)){
            JOptionPane.showMessageDialog(rootPane, "DEBE LLENAR TODOS LOS CAMPOS", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           
           else {
               
                ControladorSede cSede = new ControladorSede();
       
                ArrayList<Sede> sedes = cSede.consultarSedes();
           
                int id_sede_vehiculo = sedes.get(sede - 1).getId();
                
                ControladorVehiculo cVehiculo;
                
                for (int i = 1; i <= cantidad; i++) {
                    cVehiculo = new ControladorVehiculo();
                    int result = cVehiculo.insertarVehiculo(id_sede_vehiculo, color, marca, referencia, modelo, traccion, tipo, precio, iva);
                
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTRAR EL VEHICULO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        break;
                    }

                    else if ((i + 1) > cantidad){
                        JOptionPane.showMessageDialog(rootPane, "VEHICULO REGISTRADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                    }
                }  
           }
       }       
       catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(rootPane, "EL PRECIO Y LA CANTIDAD DEBEN SER NUMEROS", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonAñadirVehiculoActionPerformed

    private void botonAñadirRepuestoVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirRepuestoVehiculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAñadirRepuestoVehiculoActionPerformed

    private void botonAñadirRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAñadirRepuestoActionPerformed
         try {
           int precio = Integer.parseInt(precio_repuesto.getText());      
           int cantidad = Integer.parseInt(cantidad_repuesto.getText());
           int iva =  precio*(16/100);
           int sede = comboBoxSedeRepuestosInventario.getSelectedIndex();
           String nombre = nombre_repuesto.getText();
           String descripcion = descripcion_repuesto.getText();

           
                      
           if( (sede == 0) | (cantidad <= 0) | (descripcion.equals("")) | (nombre.equals("")) | (precio <= 0)){
            JOptionPane.showMessageDialog(rootPane, "DEBE LLENAR TODOS LOS CAMPOS", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           
           else {
               
                ControladorSede cSede = new ControladorSede();
       
                ArrayList<Sede> sedes = cSede.consultarSedes();
           
                int id_sede_vehiculo = sedes.get(sede - 1).getId();
                
                ControladorRepuesto cRepuesto = new ControladorRepuesto();
                
                int result = cRepuesto.insertarRepuesto(sede, nombre, cantidad, precio, iva, descripcion);
                
                if ((result == -2) | (result == -3)) {
                    JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTRAR EL REPUESTO", "AutosABC", JOptionPane.ERROR_MESSAGE);

                }

                else{
                    JOptionPane.showMessageDialog(rootPane, "REPUESTO REGISTRADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                }
           }
       }       
       catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(rootPane, "EL PRECIO Y LA CANTIDAD DEBEN SER NUMEROS", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonAñadirRepuestoActionPerformed

    private void radioBotonGeneroFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonGeneroFActionPerformed
       radioBotonGeneroM.setSelected(false);
    }//GEN-LAST:event_radioBotonGeneroFActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAyudaCrearUsuario;
    private javax.swing.JButton botonAyudaCrearUsuario1;
    private javax.swing.JButton botonAñadirRepuesto;
    private javax.swing.JButton botonAñadirRepuestoVehiculo;
    private javax.swing.JButton botonAñadirVehiculo;
    private javax.swing.JButton botonCrearInventario;
    private javax.swing.JButton botonCrearSede;
    private javax.swing.JButton botonCrearUsuario;
    private javax.swing.JButton botonCrearUsuarioConfirmacion;
    private javax.swing.JButton botonInventarioGerente;
    private javax.swing.JButton botonModificarInventario;
    private javax.swing.JButton botonModificarUsuario;
    private javax.swing.JButton botonPanelInventarioCrearRepuesto;
    private javax.swing.JButton botonPanelInventarioCrearVehiculo;
    private javax.swing.JButton botonReportesGerente;
    private javax.swing.JButton botonSedesGerente;
    private javax.swing.JButton botonUsuariosGerente;
    private javax.swing.JTextField cantidad_repuesto;
    private javax.swing.JTextField cantidad_vehiculo;
    private javax.swing.JTextField cedula_usuario;
    private javax.swing.JTextField ciudad_sede;
    private javax.swing.JTextField color_vehiculo;
    private javax.swing.JComboBox<String> comboBoxCargoUsuario;
    private javax.swing.JComboBox<String> comboBoxRepuestoVehiculo;
    private javax.swing.JComboBox<String> comboBoxSedeCrearUsuario;
    private javax.swing.JComboBox<String> comboBoxSedeRepuestosInventario;
    private javax.swing.JComboBox<String> comboBoxSedeVehiculosInventario;
    private javax.swing.JComboBox<String> comboBoxTipoVehiculo;
    private javax.swing.JComboBox<String> comboBoxTraccionVehiculo;
    private javax.swing.JTextField contrasena_usuario;
    private javax.swing.JTextField cuenta_usuario;
    private javax.swing.JTextField descripcion_repuesto;
    private javax.swing.JTextField dir_sede;
    private javax.swing.JTextField direccion_usuario;
    private javax.swing.JTextField email_usuario;
    private javax.swing.JTextField fax_sede;
    private javax.swing.JTextField id_sede;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField marca_vehiculo;
    private javax.swing.JTextField modelo_vehiculo;
    private javax.swing.JTextField nacimiento_usuario;
    private javax.swing.JTextField nombre_repuesto;
    private javax.swing.JTextField nombre_sede;
    private javax.swing.JTextField nombre_usuario;
    private javax.swing.JPanel panelConsultarSede;
    private javax.swing.JPanel panelCrearInventario;
    private javax.swing.JPanel panelCrearInventarioCrearRepuesto;
    private javax.swing.JPanel panelCrearInventarioCrearRepuestoVacio;
    private javax.swing.JPanel panelCrearInventarioCrearVehiculo;
    private javax.swing.JPanel panelCrearInventarioCrearVehiculoVacio;
    private javax.swing.JPanel panelCrearSede;
    private javax.swing.JPanel panelCrearUsuario;
    private javax.swing.JPanel panelGerente;
    private javax.swing.JPanel panelInventarioGerente;
    private javax.swing.JPanel panelModificarInventario;
    private javax.swing.JPanel panelModificarInventarioModificarRepuesto;
    private javax.swing.JPanel panelModificarInventarioModificarRepuestoVacio;
    private javax.swing.JPanel panelModificarInventarioModificarVehiculo;
    private javax.swing.JPanel panelModificarInventarioModificarVehiculoVacio;
    private javax.swing.JPanel panelModificarSede;
    private javax.swing.JPanel panelModificarUsuario;
    private javax.swing.JPanel panelReportesGerente;
    private javax.swing.JPanel panelSedeConsultaFiltroOFF;
    private javax.swing.JPanel panelSedeConsultaFiltroON;
    private javax.swing.JPanel panelSedeGerente;
    private javax.swing.JPanel panelUsuariosGerente;
    private javax.swing.JTextField precio_repuesto;
    private javax.swing.JTextField precio_vehiculo;
    private javax.swing.JRadioButton radioBotonGeneroF;
    private javax.swing.JRadioButton radioBotonGeneroM;
    private javax.swing.JTextField referencia_vehiculo;
    private javax.swing.JTextField salario_usuario;
    private javax.swing.JComboBox<String> seleccionFiltroSede;
    private javax.swing.JComboBox<String> seleccionarSede;
    private javax.swing.JTextField telefono_sede;
    private javax.swing.JTextField telefono_usuario;
    // End of variables declaration//GEN-END:variables
}
