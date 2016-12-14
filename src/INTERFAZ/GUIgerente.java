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
import java.util.Calendar;

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
    ArrayList<Vehiculo> vehiculos;
    ArrayList<Vehiculo> vehiculosAenviar; 
    ArrayList<Sede> sedesCambioSede;
    ArrayList<Sede> sedesCrearUsuario;
    int bloqueoAction;
    int reporteEscogido;
    JComboBox comboBoxMesReporte1;
    JTextField campoValorReporte2;

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
        
        card3.addLayoutComponent(panelCrearSede, "CREAR-SEDE");
        card3.addLayoutComponent(panelConsultarSede, "CONSULTAR-SEDE");
        card3.addLayoutComponent(panelModificarSede, "MODIFICAR-SEDE");
        
     
        ventanaUsuarios.addLayoutComponent(panelCrearUsuario,"CREAR-USUARIO");
        ventanaUsuarios.addLayoutComponent(panelModificarUsuario,"MODIFICAR-USUARIO");
        ventanaUsuarios.addLayoutComponent(panelConsultarUsuario, "CONSULTA-USUARIO");
        
        ventanaInventario.addLayoutComponent(panelCrearInventario,"CREAR-INVENTARIO");
        ventanaInventario.addLayoutComponent(panelModificarInventario,"MODIFICAR-INVENTARIO");
        ventanaInventario.addLayoutComponent(panelConsultarInventario, "CONSULTA-INVENTARIO");
        
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
        
        jPanel9.add(panelCrearSede);
        jPanel9.add(panelModificarSede);
        jPanel9.add(panelConsultarSede);
        
        jPanel11.add(panelCrearUsuario);
        jPanel11.add(panelModificarUsuario);
        jPanel11.add(panelConsultarUsuario);
        
        jPanel13.add(panelCrearInventario);
        jPanel13.add(panelModificarInventario);
        jPanel13.add(panelConsultarInventario);
        
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
        
        ControladorVehiculo cVehiculo = new ControladorVehiculo();
        vehiculos = cVehiculo.consultarVehiculos();
        vehiculosAenviar = new ArrayList<>();
        bloqueoAction = 0;
        reporteEscogido = 0;
        comboBoxMesReporte1 = new JComboBox();
        campoValorReporte2 = new JTextField();
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
        botonModificarSede = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        panelUsuariosGerente = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        botonCrearUsuario = new javax.swing.JButton();
        botonModificarUsuario = new javax.swing.JButton();
        botonConsultarUsuario = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        panelInventarioGerente = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        botonCrearInventario = new javax.swing.JButton();
        botonModificarInventario = new javax.swing.JButton();
        botonConsultarInventario = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        panelReportesGerente = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        botonReporteNumero1 = new javax.swing.JButton();
        botonReporteNumero2 = new javax.swing.JButton();
        botonReporte3 = new javax.swing.JButton();
        botonReporte4 = new javax.swing.JButton();
        botonReporte5 = new javax.swing.JButton();
        botonReporte6 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        areaTextoReportes = new javax.swing.JTextArea();
        panelConsultarSede = new javax.swing.JPanel();
        seleccionarSede = new javax.swing.JComboBox<>();
        atributoSede = new javax.swing.JComboBox<>();
        boton_consultar_sede = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaTextoConsultaSede = new javax.swing.JTextArea();
        jLabel47 = new javax.swing.JLabel();
        valor_consulta_sede = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        botonAyudaConsultaSede = new javax.swing.JButton();
        panelModificarSede = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        comboBoxSedeCambio = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        comboBoxDatoACambiar = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        valor_actual_sede = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        valor_nuevo_sede = new javax.swing.JTextField();
        botonAplicarCambioSede = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        areTextoModificacionSede = new javax.swing.JTextArea();
        botonRefrescarSede = new javax.swing.JButton();
        botonAyudaModificarSede = new javax.swing.JButton();
        panelCrearSede = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        botonCrearSede = new javax.swing.JButton();
        botonAyudaCrearSede = new javax.swing.JButton();
        fax_sede = new javax.swing.JTextField();
        telefono_sede = new javax.swing.JTextField();
        dir_sede = new javax.swing.JTextField();
        ciudad_sede = new javax.swing.JTextField();
        nombre_sede = new javax.swing.JTextField();
        id_sede = new javax.swing.JTextField();
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
        cedula_modificar_usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nuevo_valor_usuario = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        comboBoxAtributoUsuario = new javax.swing.JComboBox<>();
        botonModificarAtributoUsuario = new javax.swing.JButton();
        botonAyudaModificarUsuario = new javax.swing.JButton();
        panelConsultarUsuario = new javax.swing.JPanel();
        comboBoxBusquedaUsuario = new javax.swing.JComboBox<>();
        boton_consultar_usuario = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        areaTextoConsultaUsuario = new javax.swing.JTextArea();
        jLabel48 = new javax.swing.JLabel();
        valor_consulta_usuario = new javax.swing.JTextField();
        botonAyudaConsultaUsuario = new javax.swing.JButton();
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
        areaVehiculosAñadidos = new javax.swing.JTextArea();
        botonAñadirRepuestoVehiculo = new javax.swing.JButton();
        panelCrearInventarioCrearVehiculoVacio = new javax.swing.JPanel();
        panelCrearInventarioCrearRepuestoVacio = new javax.swing.JPanel();
        panelModificarInventarioModificarVehiculo = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        id_modificar_vehiculo = new javax.swing.JTextField();
        botonModificarVehiculo = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        comboBoxAtributoVehiculo = new javax.swing.JComboBox<>();
        jLabel63 = new javax.swing.JLabel();
        nuevo_valor_vehiculo = new javax.swing.JTextField();
        panelModificarInventarioModificarVehiculoVacio = new javax.swing.JPanel();
        panelModificarInventarioModificarRepuestoVacio = new javax.swing.JPanel();
        panelModificarInventarioModificarRepuesto = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        id_modificar_respuesto = new javax.swing.JTextField();
        botonModificarRepuesto = new javax.swing.JButton();
        jLabel58 = new javax.swing.JLabel();
        comboBoxAtributoRepuesto = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        nuevo_valor_repuesto = new javax.swing.JTextField();
        panelConsultarInventario = new javax.swing.JPanel();
        comboBosBusquedaInventario = new javax.swing.JComboBox<>();
        boton_consultar_inventario = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaTextoConsultaInventario = new javax.swing.JTextArea();
        jLabel49 = new javax.swing.JLabel();
        valor_consulta_inventario = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        radioBotonVehiculo = new javax.swing.JRadioButton();
        radioBotonRepuesto = new javax.swing.JRadioButton();
        radioBotonVenta = new javax.swing.JRadioButton();
        radioBotonCotizacion = new javax.swing.JRadioButton();
        radioBotonOrden = new javax.swing.JRadioButton();
        construccion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        panelAyudas = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        areaAyuda = new javax.swing.JTextArea();

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
        botonSedesGerente.setToolTipText("Para gestionar Sedes");
        botonSedesGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSedesGerenteActionPerformed(evt);
            }
        });

        botonUsuariosGerente.setText("USUARIOS");
        botonUsuariosGerente.setToolTipText("Para gestionar Usuarios");
        botonUsuariosGerente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonUsuariosGerenteActionPerformed(evt);
            }
        });

        botonReportesGerente.setText("REPORTES");
        botonReportesGerente.setToolTipText("Para generar reportes");
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
        botonInventarioGerente.setToolTipText("Para gestionar vehiculos, repuestos, ventas, cotizaciones, ordenes de talle");
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

        botonModificarSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/MODIFICAR-SEDE.png"))); // NOI18N
        botonModificarSede.setToolTipText("Al hacer click en este boton, se desplegará  el menu para modificar sedes");
        botonModificarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarSedeActionPerformed(evt);
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
                        .addComponent(botonModificarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addComponent(botonModificarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        botonConsultarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ICONO-CONSULTAR-USUARIO.png"))); // NOI18N
        botonConsultarUsuario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para modificar usuarios");
        botonConsultarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(botonModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botonCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botonConsultarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonConsultarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        botonConsultarInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ICONO-CONSULTAR-INVENTARIO.png"))); // NOI18N
        botonConsultarInventario.setToolTipText("Al hacer click en este boton, se desplegará  el menu para realizar consultas relazionas con el inventario");
        botonConsultarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultarInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonCrearInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonModificarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonConsultarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(botonCrearInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonModificarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botonConsultarInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        jPanel14.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        botonReporteNumero1.setText("R1");
        botonReporteNumero1.setToolTipText("Genera el reporte numero 1");
        botonReporteNumero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteNumero1ActionPerformed(evt);
            }
        });

        botonReporteNumero2.setText("R2");
        botonReporteNumero2.setToolTipText("Genera el reporte numero 2");
        botonReporteNumero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporteNumero2ActionPerformed(evt);
            }
        });

        botonReporte3.setText("R3");
        botonReporte3.setToolTipText("Genera el reporte numero 3");
        botonReporte3.setBorderPainted(false);
        botonReporte3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporte3ActionPerformed(evt);
            }
        });

        botonReporte4.setText("R4");
        botonReporte4.setToolTipText("Genera el reporte numero 4");
        botonReporte4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporte4ActionPerformed(evt);
            }
        });

        botonReporte5.setText("R5");
        botonReporte5.setToolTipText("Genera el reporte numero 5");
        botonReporte5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporte5ActionPerformed(evt);
            }
        });

        botonReporte6.setText("R6");
        botonReporte6.setToolTipText("Genera el reporte numero 6");
        botonReporte6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        botonReporte6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonReporte6ActionPerformed(evt);
            }
        });

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ICONO-AYUDA-REPORTES.jpg"))); // NOI18N
        jButton18.setToolTipText("Para obtener ayuda acerca de los reportes");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botonReporte6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(botonReporte5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonReporte4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonReporte3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonReporteNumero2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonReporteNumero1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonReporteNumero1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporteNumero2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporte3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporte4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporte5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botonReporte6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        areaTextoReportes.setEditable(false);
        areaTextoReportes.setColumns(20);
        areaTextoReportes.setRows(5);
        jScrollPane6.setViewportView(areaTextoReportes);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelReportesGerenteLayout = new javax.swing.GroupLayout(panelReportesGerente);
        panelReportesGerente.setLayout(panelReportesGerenteLayout);
        panelReportesGerenteLayout.setHorizontalGroup(
            panelReportesGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportesGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelReportesGerenteLayout.setVerticalGroup(
            panelReportesGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelReportesGerenteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelReportesGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelConsultarSede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelConsultarSede.setPreferredSize(new java.awt.Dimension(586, 366));

        seleccionarSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        atributoSede.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por...", "Identificacion", "Nombre", "Ciudad" }));
        atributoSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atributoSedeActionPerformed(evt);
            }
        });

        boton_consultar_sede.setText("CONSULTAR");
        boton_consultar_sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_consultar_sedeActionPerformed(evt);
            }
        });

        areaTextoConsultaSede.setEditable(false);
        areaTextoConsultaSede.setColumns(20);
        areaTextoConsultaSede.setRows(5);
        jScrollPane1.setViewportView(areaTextoConsultaSede);

        jLabel47.setText("VALOR BUSQUEDA:");

        jLabel4.setText("SEDE O ATRIBUTO:");

        botonAyudaConsultaSede.setText("AYUDA");
        botonAyudaConsultaSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaConsultaSedeActionPerformed(evt);
            }
        });

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
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(seleccionarSede, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(atributoSede, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                                .addComponent(jLabel47)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor_consulta_sede, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(36, 36, 36)
                        .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_consultar_sede, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(botonAyudaConsultaSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelConsultarSedeLayout.setVerticalGroup(
            panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(seleccionarSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(atributoSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addComponent(boton_consultar_sede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(valor_consulta_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAyudaConsultaSede))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
                .addContainerGap())
        );

        panelModificarSede.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelModificarSede.setPreferredSize(new java.awt.Dimension(586, 366));

        jLabel11.setText("MODIFICAR SEDE");

        jLabel12.setText("SELECCIONE LA SEDE:");

        comboBoxSedeCambio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBoxSedeCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxSedeCambioActionPerformed(evt);
            }
        });

        jLabel13.setText("DATO A CAMBIAR:");

        comboBoxDatoACambiar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una", "Nombre", "Ciudad", "Direccion", "Telefono", "Fax" }));
        comboBoxDatoACambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxDatoACambiarActionPerformed(evt);
            }
        });

        jLabel14.setText("VALOR ACTUAL:");

        valor_actual_sede.setEditable(false);

        jLabel41.setText("NUEVO VALOR:");

        botonAplicarCambioSede.setText("APLICAR CAMBIO");
        botonAplicarCambioSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAplicarCambioSedeActionPerformed(evt);
            }
        });

        areTextoModificacionSede.setEditable(false);
        areTextoModificacionSede.setColumns(20);
        areTextoModificacionSede.setRows(5);
        jScrollPane2.setViewportView(areTextoModificacionSede);

        botonRefrescarSede.setText("REFRESCAR");
        botonRefrescarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRefrescarSedeActionPerformed(evt);
            }
        });

        botonAyudaModificarSede.setText("AYUDA");
        botonAyudaModificarSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaModificarSedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelModificarSedeLayout = new javax.swing.GroupLayout(panelModificarSede);
        panelModificarSede.setLayout(panelModificarSedeLayout);
        panelModificarSedeLayout.setHorizontalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(panelModificarSedeLayout.createSequentialGroup()
                        .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxSedeCambio, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboBoxDatoACambiar, 0, 205, Short.MAX_VALUE)))
                            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor_actual_sede))
                            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor_nuevo_sede)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(botonAplicarCambioSede, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(botonRefrescarSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonAyudaModificarSede, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(58, 58, 58))))
        );
        panelModificarSedeLayout.setVerticalGroup(
            panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarSedeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(comboBoxSedeCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAplicarCambioSede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(comboBoxDatoACambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonRefrescarSede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(valor_actual_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAyudaModificarSede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarSedeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(valor_nuevo_sede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
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

        botonAyudaCrearSede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono ayuda.jpg"))); // NOI18N
        botonAyudaCrearSede.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAyudaCrearSede.setName(""); // NOI18N
        botonAyudaCrearSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaCrearSedeActionPerformed(evt);
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
                        .addComponent(botonAyudaCrearSede, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(botonAyudaCrearSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonCrearSede, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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

        comboBoxAtributoUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un Atributo", "Nombre", "Direccion", "E-mail", "Telefono", "Sede", "Estado", "Salario", "Usuario y Contraseña" }));
        comboBoxAtributoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxAtributoUsuarioActionPerformed(evt);
            }
        });

        botonModificarAtributoUsuario.setText("MODIFICAR");
        botonModificarAtributoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarAtributoUsuarioActionPerformed(evt);
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
                        .addComponent(comboBoxAtributoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(nuevo_valor_usuario))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(botonModificarAtributoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(comboBoxAtributoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(nuevo_valor_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonModificarAtributoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        botonAyudaModificarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono ayuda.jpg"))); // NOI18N
        botonAyudaModificarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAyudaModificarUsuario.setName(""); // NOI18N
        botonAyudaModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaModificarUsuarioActionPerformed(evt);
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
                        .addComponent(cedula_modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(botonAyudaModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelModificarUsuarioLayout.setVerticalGroup(
            panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelModificarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelModificarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(cedula_modificar_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(botonAyudaModificarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panelConsultarUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelConsultarUsuario.setPreferredSize(new java.awt.Dimension(586, 366));

        comboBoxBusquedaUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Buscar por...", "Todos", "Cedula", "Sede", "Nombre", "Genero", "Cargo", "Salario", "Estado" }));
        comboBoxBusquedaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxBusquedaUsuarioActionPerformed(evt);
            }
        });

        boton_consultar_usuario.setText("CONSULTAR");
        boton_consultar_usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_consultar_usuarioActionPerformed(evt);
            }
        });

        areaTextoConsultaUsuario.setEditable(false);
        areaTextoConsultaUsuario.setColumns(20);
        areaTextoConsultaUsuario.setRows(5);
        jScrollPane4.setViewportView(areaTextoConsultaUsuario);

        jLabel48.setText("VALOR BUSQUEDA:");

        botonAyudaConsultaUsuario.setText("AYUDA");
        botonAyudaConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAyudaConsultaUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultarUsuarioLayout = new javax.swing.GroupLayout(panelConsultarUsuario);
        panelConsultarUsuario.setLayout(panelConsultarUsuarioLayout);
        panelConsultarUsuarioLayout.setHorizontalGroup(
            panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4)
                    .addGroup(panelConsultarUsuarioLayout.createSequentialGroup()
                        .addGroup(panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelConsultarUsuarioLayout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(valor_consulta_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboBoxBusquedaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_consultar_usuario, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
                            .addComponent(botonAyudaConsultaUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelConsultarUsuarioLayout.setVerticalGroup(
            panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_consultar_usuario)
                    .addComponent(comboBoxBusquedaUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(valor_consulta_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonAyudaConsultaUsuario))
                .addGap(19, 19, 19)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
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

        areaVehiculosAñadidos.setEditable(false);
        areaVehiculosAñadidos.setColumns(20);
        areaVehiculosAñadidos.setRows(5);
        jScrollPane3.setViewportView(areaVehiculosAñadidos);

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

        jLabel60.setText("INFORMACION VEHICULO:");

        jLabel61.setText("ID:");

        botonModificarVehiculo.setText("MODIFICAR");
        botonModificarVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarVehiculoActionPerformed(evt);
            }
        });

        jLabel62.setText("ATRIBUTO");

        comboBoxAtributoVehiculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una", "Sede", "Precio", "Iva", "Estado" }));

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
                        .addComponent(id_modificar_vehiculo))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel62)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxAtributoVehiculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(botonModificarVehiculo))
                            .addComponent(jLabel60))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarVehiculoLayout.createSequentialGroup()
                        .addComponent(jLabel63)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuevo_valor_vehiculo)))
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
                    .addComponent(id_modificar_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(comboBoxAtributoVehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarInventarioModificarVehiculoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(nuevo_valor_vehiculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(botonModificarVehiculo)
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

        panelModificarInventarioModificarRepuesto.setPreferredSize(new java.awt.Dimension(258, 276));

        jLabel52.setText("INFORMACION REPUESTO:");

        jLabel53.setText("ID:");

        botonModificarRepuesto.setText("MODIFICAR");
        botonModificarRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonModificarRepuestoActionPerformed(evt);
            }
        });

        jLabel58.setText("ATIRBUTO");

        comboBoxAtributoRepuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Una", "Sede", "Nombre", "Cantidad", "Precio", "Iva", "Asociar a Vehiculo" }));

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
                        .addComponent(id_modificar_respuesto))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel58)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxAtributoRepuesto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(botonModificarRepuesto))
                            .addComponent(jLabel52))
                        .addGap(0, 70, Short.MAX_VALUE))
                    .addGroup(panelModificarInventarioModificarRepuestoLayout.createSequentialGroup()
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nuevo_valor_repuesto)))
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
                    .addComponent(id_modificar_respuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(comboBoxAtributoRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelModificarInventarioModificarRepuestoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(nuevo_valor_repuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(botonModificarRepuesto)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelModificarInventarioModificarRepuestoVacioLayout = new javax.swing.GroupLayout(panelModificarInventarioModificarRepuestoVacio);
        panelModificarInventarioModificarRepuestoVacio.setLayout(panelModificarInventarioModificarRepuestoVacioLayout);
        panelModificarInventarioModificarRepuestoVacioLayout.setHorizontalGroup(
            panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelModificarInventarioModificarRepuestoVacioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelModificarInventarioModificarRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelModificarInventarioModificarRepuestoVacioLayout.setVerticalGroup(
            panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(panelModificarInventarioModificarRepuestoVacioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelModificarInventarioModificarRepuestoVacioLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(panelModificarInventarioModificarRepuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panelConsultarInventario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelConsultarInventario.setPreferredSize(new java.awt.Dimension(586, 366));

        comboBosBusquedaInventario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Consulta" }));

        boton_consultar_inventario.setText("CONSULTAR");
        boton_consultar_inventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_consultar_inventarioActionPerformed(evt);
            }
        });

        areaTextoConsultaInventario.setEditable(false);
        areaTextoConsultaInventario.setColumns(20);
        areaTextoConsultaInventario.setRows(5);
        jScrollPane5.setViewportView(areaTextoConsultaInventario);

        jLabel49.setText("VALOR BUSQUEDA:");

        jButton3.setText("AYUDA");

        radioBotonVehiculo.setText("Vehiculo");
        radioBotonVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonVehiculoActionPerformed(evt);
            }
        });

        radioBotonRepuesto.setText("Repuesto");
        radioBotonRepuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonRepuestoActionPerformed(evt);
            }
        });

        radioBotonVenta.setText("Venta");
        radioBotonVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonVentaActionPerformed(evt);
            }
        });

        radioBotonCotizacion.setText("Cotizacion");
        radioBotonCotizacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonCotizacionActionPerformed(evt);
            }
        });

        radioBotonOrden.setText("Orden");
        radioBotonOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBotonOrdenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelConsultarInventarioLayout = new javax.swing.GroupLayout(panelConsultarInventario);
        panelConsultarInventario.setLayout(panelConsultarInventarioLayout);
        panelConsultarInventarioLayout.setHorizontalGroup(
            panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addGroup(panelConsultarInventarioLayout.createSequentialGroup()
                        .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelConsultarInventarioLayout.createSequentialGroup()
                                .addComponent(radioBotonVehiculo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radioBotonRepuesto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(radioBotonVenta))
                            .addComponent(comboBosBusquedaInventario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBotonCotizacion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioBotonOrden)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                        .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton_consultar_inventario, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelConsultarInventarioLayout.createSequentialGroup()
                        .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valor_consulta_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel49))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelConsultarInventarioLayout.setVerticalGroup(
            panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelConsultarInventarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boton_consultar_inventario)
                    .addComponent(radioBotonVehiculo)
                    .addComponent(radioBotonRepuesto)
                    .addComponent(radioBotonVenta)
                    .addComponent(radioBotonCotizacion)
                    .addComponent(radioBotonOrden))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelConsultarInventarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addComponent(comboBosBusquedaInventario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(valor_consulta_inventario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addContainerGap())
        );

        construccion.setPreferredSize(new java.awt.Dimension(717, 388));

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/INTERFAZ/icono-construccion.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel33)
                .addGap(58, 58, 58))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout construccionLayout = new javax.swing.GroupLayout(construccion);
        construccion.setLayout(construccionLayout);
        construccionLayout.setHorizontalGroup(
            construccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(construccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        construccionLayout.setVerticalGroup(
            construccionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(construccionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        areaAyuda.setBackground(new java.awt.Color(240, 240, 240));
        areaAyuda.setColumns(20);
        areaAyuda.setRows(5);
        jScrollPane8.setViewportView(areaAyuda);

        javax.swing.GroupLayout panelAyudasLayout = new javax.swing.GroupLayout(panelAyudas);
        panelAyudas.setLayout(panelAyudasLayout);
        panelAyudasLayout.setHorizontalGroup(
            panelAyudasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelAyudasLayout.setVerticalGroup(
            panelAyudasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAyudasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
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
        seleccionarSede.addItem("Todas las sedes");
        
        ControladorSede cSede = new ControladorSede();
        
        ArrayList<Sede> sedes = cSede.consultarSedes();
        
        for (int i = 0; i < sedes.size(); i++){
            seleccionarSede.addItem(sedes.get(i).getNombre());
        }
 
    }//GEN-LAST:event_jButton15ActionPerformed

    private void botonModificarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarSedeActionPerformed
        card3.show(jPanel9, "MODIFICAR-SEDE");
        
        sedesCambioSede = new ArrayList<>();
        
        comboBoxSedeCambio.removeAllItems();
        comboBoxSedeCambio.addItem("Seleccione una");

        ControladorSede cSede = new ControladorSede();

        sedesCambioSede = cSede.consultarSedes();

        for (int i = 0; i < sedesCambioSede.size(); i++) {
            comboBoxSedeCambio.addItem(sedesCambioSede.get(i).getNombre());
        }
        
        botonRefrescarSede.setEnabled(false);
    }//GEN-LAST:event_botonModificarSedeActionPerformed

    private void botonUsuariosGerenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonUsuariosGerenteActionPerformed
        card2.show(jPanel3, "USUARIOS");
        
        comboBoxSedeCrearUsuario.removeAllItems();
        comboBoxSedeCrearUsuario.addItem("Seleccione una");

        ControladorSede cSede = new ControladorSede();

        sedesCrearUsuario = cSede.consultarSedes();

        for (int i = 0; i < sedesCrearUsuario.size(); i++) {
            comboBoxSedeCrearUsuario.addItem(sedesCrearUsuario.get(i).getNombre());
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

    private void botonAyudaCrearSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaCrearSedeActionPerformed
        String informacion = "EN ESTE ESPACIO PARA LA CREACION DE SEDES DEBE RECORDAR QUE: \n\n"
                + "1) La identificacion, el telefono y el fax son numeros\n"
                + "2) La identificacion debe ser unica, es decir, no deben haber 2 sedes con el mismo id\n";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaCrearSedeActionPerformed

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

    private void atributoSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atributoSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_atributoSedeActionPerformed

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

        sedesCrearUsuario = cSede.consultarSedes();

        for (int i = 0; i < sedesCrearUsuario.size(); i++) {
            comboBoxSedeCrearUsuario.addItem(sedesCrearUsuario.get(i).getNombre());
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
        String informacion = "Para la creación de un usuario deberá presionar en el botón “Usuarios” del menú \n"
                + "superior y el sistema cargará en el panel izquierdo los botones necesarios para la gestión\n"
                + " de usuarios. A continuación presione el botón “Crear usuario” (el que tiene una persona \n"
                + "con un ‘+’), del panel izquierdo y diligencie el formulario. Posteriormente presione el \n"
                + "botón “Crear Usuario” de la parte inferior el Sistema validará la información de los \n"
                + "campos y hará la creación del usuario con la información proporcionada.\n\n"
                + "En dicha validacion se debe tener muy presente que los campos de cedula, telefono y salario\n"
                + "deben ser datos numericos, además que el campo fecha de nacimiento debe \n"
                + "seguir el siguiente formato: AAAA-MM-DD. Cuando cree el usuario recuerde \n"
                + "guardar el pin que es mostrado en pantalla, pues no se podra recuperar de ninguna forma.";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaCrearUsuarioActionPerformed

    private void comboBoxAtributoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxAtributoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxAtributoUsuarioActionPerformed

    private void botonAyudaModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaModificarUsuarioActionPerformed
        String informacion = "Para la modificación de un usuario deberá presionar en el botón “Usuarios” del menú\n"
                + " superior y el sistema cargará en el panel izquierdo los botones necesarios para la gestión\n"
                + " de usuarios. A continuación presione el botón “Modificar usuario” (el que tiene una\n"
                + " persona con una rueda), del panel izquierdo y diligencie el número de cédula. Seguido\n"
                + " del campo que desea modificar y el valor que desea colocar.\n" +"\n" +"\n" 
                + "Posteriormente presione el botón “Modificar” de la parte inferior el Sistema validará la \n"
                + " información de los campos y hará la modificación del usuario con la\n"
                + " información proporcionada.";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaModificarUsuarioActionPerformed

    private void botonModificarAtributoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarAtributoUsuarioActionPerformed
       try{
           int cedula = Integer.parseInt(cedula_modificar_usuario.getText());
           
           if(comboBoxAtributoUsuario.getSelectedIndex() == 0){
                 JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UN ATRIBUTO PARA MODIFICAR", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           
           else {
               int index = comboBoxAtributoUsuario.getSelectedIndex();
               ControladorUsuario cUsuario = new ControladorUsuario();
               int result;
               switch(index) {
                   case 1:
                       String nombre = nuevo_valor_usuario.getText();
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarNombre(cedula, nombre);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 2:
                       String direccion = nuevo_valor_usuario.getText();
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarDireccion(cedula, direccion);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 3:
                       String email = nuevo_valor_usuario.getText();
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarEmail(cedula, email);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 4:
                       String telefono = Long.toString(Long.parseLong(nuevo_valor_usuario.getText()));
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarTelefono(cedula, telefono);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 5:
                       int sede = Integer.parseInt(nuevo_valor_usuario.getText());
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarSede(cedula, sede);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 6:
                       String estado = nuevo_valor_usuario.getText();
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarEstado(cedula, estado);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 7:
                       int salario = Integer.parseInt(nuevo_valor_usuario.getText());
                       cUsuario = new ControladorUsuario();
                       result = cUsuario.cambiarSalario(cedula, salario);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 8:
                       String UsuANDPass = nuevo_valor_usuario.getText();
                       cUsuario = new ControladorUsuario();
                       Encriptacion encripto = new Encriptacion();
                       ArrayList<String> cuentaE = encripto.encriptar(UsuANDPass);
                       ArrayList<String> contrasenaE = encripto.encriptar(UsuANDPass);
                       String PIN = contrasenaE.get(1) + cuentaE.get(1);
                       result = cUsuario.cambiarUsuANDpass(cedula, cuentaE.get(0), contrasenaE.get(0));
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO\n\nEL PIN PARA EL USUARIO ES:" + PIN, "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
               }
           }
       }
       catch(NumberFormatException e) {
             JOptionPane.showMessageDialog(rootPane, "LA CEDULA DEBEN SER NUMEROS, AL GIUAL QUE\n"
                     + "1) LA SEDE DEL USUARIO\n2) SALARIO USUARIO\n3) TELEFONO USUARIO", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonModificarAtributoUsuarioActionPerformed

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
             
       comboBoxRepuestoVehiculo.removeAllItems();
       comboBoxRepuestoVehiculo.addItem("Seleccione una");
       
       for (int i = 0; i < vehiculos.size(); i++) {
           comboBoxRepuestoVehiculo.addItem(Integer.toString(vehiculos.get(i).getVehiculo()));
       }
       
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

                    Encriptacion encripto = new Encriptacion();
                    
                    ArrayList<String> pesos_cuenta = encripto.encriptar(usuario);
                    ArrayList<String> pesos_contrasena = encripto.encriptar(contrasena);
                    
                    String PIN =  pesos_contrasena.get(1) + pesos_cuenta.get(1);

                    ControladorUsuario nuevoUsuario = new ControladorUsuario();
                    int result = nuevoUsuario.insertarUsuario(
                            cedula,
                            id_sede_usuario, 
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
                    int result = cVehiculo.insertarVehiculo(id_sede_vehiculo, color, marca, referencia, modelo, traccion, tipo, precio, iva, "Disponible");
                
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
        try{
            
            int id_vehiculo = comboBoxRepuestoVehiculo.getSelectedIndex();
            Vehiculo unVehiculo = new Vehiculo();
            
            if (id_vehiculo == 0){
            
            }
            
            else {
                unVehiculo = vehiculos.get(id_vehiculo - 1);
                vehiculos.remove(id_vehiculo - 1);
                vehiculosAenviar.add(unVehiculo);
                comboBoxRepuestoVehiculo.removeAllItems();
                comboBoxRepuestoVehiculo.addItem("Seleccione una");

                for (int i = 0; i < vehiculos.size(); i++) {
                    comboBoxRepuestoVehiculo.addItem(Integer.toString(vehiculos.get(i).getVehiculo()));
                }
                areaVehiculosAñadidos.append(unVehiculo.getVehiculo() + " | " + unVehiculo.getMarca() +" | " +unVehiculo.getReferencia() +  " | " + unVehiculo.getModelo() + " | " + unVehiculo.getColor() + "\n");
            }
            
        }
        
        catch(NumberFormatException e){
        
        }
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
           
                int id_sede_repuesto = sedes.get(sede - 1).getId();
                
                ControladorRepuesto cRepuesto = new ControladorRepuesto();
                
                int result = cRepuesto.insertarRepuesto(id_sede_repuesto, nombre, cantidad, precio, iva, descripcion);
                
                if ((result == -2) | (result == -3)) {
                    JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTRAR EL REPUESTO", "AutosABC", JOptionPane.ERROR_MESSAGE);

                }

                else{
                    JOptionPane.showMessageDialog(rootPane, "REPUESTO REGISTRADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                }
                
                ControladorRepuestosDeVehiculo cRV = new ControladorRepuestosDeVehiculo();
                cRepuesto = new ControladorRepuesto();
                System.out.println("error 1");
                Repuesto repuesto = cRepuesto.consultarRepuesto(id_sede_repuesto, nombre, cantidad, precio, iva, descripcion);
                System.out.println("error 2");
                System.out.println(repuesto.getId_repuesto());
                for (int i = 0; i < vehiculosAenviar.size(); i++){
                    cRV = new ControladorRepuestosDeVehiculo();
                    result = cRV.insertarVinculo(repuesto.getId_repuesto(), vehiculosAenviar.get(i).getVehiculo());
                    if((result == -2)|(result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "NO SE PUDO REGISTRAR LA VINCULACION DEL REPUESTO CON LOS VEHICULOS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        break;
                    }
                    
                    else{
                        if((i + 1) == vehiculosAenviar.size()){
                            JOptionPane.showMessageDialog(rootPane, "VINCULACIONES VEHICULO-REPUESTO EXITOSA", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
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

    private void comboBoxSedeCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxSedeCambioActionPerformed
        if (comboBoxSedeCambio.getSelectedIndex() == 0) {
           areTextoModificacionSede.setText("SELECCIONE UNA SEDE PARA IMPRIMIR LA INFORMACIÓN O REALIZA UNA MODIFICACION");
        }
       
        else {
           int index = comboBoxSedeCambio.getSelectedIndex();
           if ((sedesCambioSede.isEmpty()) | (bloqueoAction == 1)) {
           
           }
           
           else {
             String informacionSede = "IDENTIFICACION SEDE:  "  + sedesCambioSede.get(index - 1).getId() + "\n" + 
                                      "NOMBRE SEDE:  "  + sedesCambioSede.get(index - 1).getNombre() + "\n" + 
                                      "CIUDAD SEDE:  "  + sedesCambioSede.get(index - 1).getCiudad() + "\n" + 
                                      "DIRECCION SEDE:  "  + sedesCambioSede.get(index - 1).getDireccion() + "\n" + 
                                      "TELEFONO SEDE:  "  + sedesCambioSede.get(index - 1).getTelefono() + "\n" +
                                      "FAX SEDE:  "  + sedesCambioSede.get(index - 1).getFax() + "\n\n\n";
             areTextoModificacionSede.setText(informacionSede);
           }
           
       }
    }//GEN-LAST:event_comboBoxSedeCambioActionPerformed

    private void comboBoxDatoACambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxDatoACambiarActionPerformed
       if (comboBoxSedeCambio.getSelectedIndex() == 0) {
           valor_actual_sede.setText("SELECCIONE UN ATRIBUTO");
        }
       
        else {
           int indexS = comboBoxSedeCambio.getSelectedIndex();
           int indexA = comboBoxDatoACambiar.getSelectedIndex();
           if (indexA == 0) {
               
           }
           
           else {
            String dato;
            switch (indexA){
                 
                case 1:
                    dato = "" + sedesCambioSede.get(indexS - 1).getNombre();
                    valor_actual_sede.setText(dato);
                    break;
                case 2:
                    dato = "" + sedesCambioSede.get(indexS - 1).getCiudad();
                    valor_actual_sede.setText(dato);
                    break;
                case 3:
                    dato = "" + sedesCambioSede.get(indexS - 1).getDireccion();
                    valor_actual_sede.setText(dato);
                    break;
                case 4:
                    dato = "" + sedesCambioSede.get(indexS - 1).getTelefono();
                    valor_actual_sede.setText(dato);
                    break;
                case 5:
                    dato = "" + sedesCambioSede.get(indexS - 1).getFax();
                    valor_actual_sede.setText(dato);
                    break;
             }
           }      
       }
    }//GEN-LAST:event_comboBoxDatoACambiarActionPerformed

    private void botonAplicarCambioSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAplicarCambioSedeActionPerformed
       int indexS = comboBoxSedeCambio.getSelectedIndex();
       int indexA = comboBoxDatoACambiar.getSelectedIndex();
       String nuevo_valor = valor_nuevo_sede.getText();
       
       if ((indexS == 0) | (indexS == 0) | (nuevo_valor.equals(""))) {
           JOptionPane.showMessageDialog(rootPane, "DATOS ERRONEOS, RECUERDE QUE: \n1) DEBE SELECCIONAR UNA SEDE\n2) DEBE SELECCIONAR UN ATRIBUTO\n3) DEBE INTRODUCIR UN VALOR EN EL CAMPO ''NUEVO VALOR''", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
       
       else {
           ControladorSede cSede = new ControladorSede();
           int result = 0;
           switch (indexA){
                 
                case 1:
                    cSede = new ControladorSede();
                    result = cSede.cambiarNombre(sedesCambioSede.get(indexS - 1).getId(), nuevo_valor);
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        cSede = new ControladorSede();
                        sedesCambioSede = cSede.consultarSedes();
                        botonRefrescarSede.setEnabled(true);
                        botonAplicarCambioSede.setEnabled(false);
                        bloqueoAction = 1;
                    }
                    break;
                case 2:
                    cSede = new ControladorSede();
                    result = cSede.cambiarCiudad(sedesCambioSede.get(indexS - 1).getId(), nuevo_valor);
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        cSede = new ControladorSede();
                        sedesCambioSede = cSede.consultarSedes();
                        botonRefrescarSede.setEnabled(true);
                        botonAplicarCambioSede.setEnabled(false);
                        bloqueoAction = 1;
                    }
                    break;
                case 3:
                    cSede = new ControladorSede();
                    result = cSede.cambiarDireccion(sedesCambioSede.get(indexS - 1).getId(), nuevo_valor);
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        cSede = new ControladorSede();
                        sedesCambioSede = cSede.consultarSedes();
                        botonRefrescarSede.setEnabled(true);
                        botonAplicarCambioSede.setEnabled(false);
                        bloqueoAction = 1;
                    }
                    break;
                case 4:
                    cSede = new ControladorSede();
                    result = cSede.cambiarTelefono(sedesCambioSede.get(indexS - 1).getId(), nuevo_valor);
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        cSede = new ControladorSede();
                        sedesCambioSede = cSede.consultarSedes();
                        botonRefrescarSede.setEnabled(true);
                        botonAplicarCambioSede.setEnabled(false);
                        bloqueoAction = 1;
                    }
                    break;
                case 5:
                    cSede = new ControladorSede();
                    result = cSede.cambiarFax(sedesCambioSede.get(indexS - 1).getId(), nuevo_valor);
                    if ((result == -2) | (result == -3)) {
                        JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                        cSede = new ControladorSede();
                        sedesCambioSede = cSede.consultarSedes();
                        botonRefrescarSede.setEnabled(true);
                        botonAplicarCambioSede.setEnabled(false);
                        bloqueoAction = 1;
                    }
                    break;
             }
    }
    }//GEN-LAST:event_botonAplicarCambioSedeActionPerformed

    private void botonRefrescarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRefrescarSedeActionPerformed
        comboBoxSedeCambio.removeAllItems();
        comboBoxSedeCambio.addItem("Seleccione una");

        for (int i = 0; i < sedesCambioSede.size(); i++) {
            comboBoxSedeCambio.addItem(sedesCambioSede.get(i).getNombre());
        }
        botonRefrescarSede.setEnabled(false);
        areTextoModificacionSede.setText("");
        valor_actual_sede.setText("");
        botonAplicarCambioSede.setEnabled(true);
        bloqueoAction = 0;
    }//GEN-LAST:event_botonRefrescarSedeActionPerformed

    private void botonModificarVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarVehiculoActionPerformed
        try{
           int id_vehiculo = Integer.parseInt(id_modificar_vehiculo.getText());
           
           if(comboBoxAtributoVehiculo.getSelectedIndex() == 0){
                 JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UN ATRIBUTO PARA MODIFICAR", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           
           else {
               int index = comboBoxAtributoVehiculo.getSelectedIndex();
               ControladorVehiculo cVehiculo = new ControladorVehiculo();
               int result;
               switch(index) {
                   case 1:
                       int sede = Integer.parseInt(nuevo_valor_vehiculo.getText());
                       cVehiculo = new ControladorVehiculo();
                       result = cVehiculo.modificarSede(id_vehiculo, sede);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 2:
                       int precio = Integer.parseInt(nuevo_valor_vehiculo.getText());
                       cVehiculo = new ControladorVehiculo();
                       result = cVehiculo.modificarPrecio(id_vehiculo, precio);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 3:
                       int iva = Integer.parseInt(nuevo_valor_vehiculo.getText());
                       cVehiculo = new ControladorVehiculo();
                       result = cVehiculo.modificarIva(id_vehiculo, iva);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 4:
                       String estado = nuevo_valor_vehiculo.getText();
                       cVehiculo = new ControladorVehiculo();
                       result = cVehiculo.modificarEstado(id_vehiculo, estado);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
               }
           }
       }
       catch(NumberFormatException e) {
             JOptionPane.showMessageDialog(rootPane, "EL ID DEBEN SER NUMEROS, AL GIUAL QUE\n"
                     + "1) LA SEDE DEL VEHICULO\n2) EL PRECIO DEL VEHICULO\n3) EL IVA DEL VEHICULO", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonModificarVehiculoActionPerformed

    private void botonModificarRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonModificarRepuestoActionPerformed
        try{
           int id_repuesto = Integer.parseInt(id_modificar_respuesto.getText());
           
           if(comboBoxAtributoRepuesto.getSelectedIndex() == 0){
                 JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UN ATRIBUTO PARA MODIFICAR", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           
           else {
               int index = comboBoxAtributoRepuesto.getSelectedIndex();
               ControladorRepuesto cRepuesto = new ControladorRepuesto();
               int result;
               switch(index) {
                   case 1:
                       int sede = Integer.parseInt(nuevo_valor_repuesto.getText());
                       cRepuesto = new ControladorRepuesto();
                       result = cRepuesto.cambiarSede(id_repuesto, sede);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 2:
                       String nombre = nuevo_valor_vehiculo.getText();
                       cRepuesto = new ControladorRepuesto();
                       result = cRepuesto.cambiarNombre(id_repuesto, nombre);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 3:
                       int cantidad = Integer.parseInt(nuevo_valor_repuesto.getText());
                       cRepuesto = new ControladorRepuesto();
                       result = cRepuesto.cambiarCantidad(id_repuesto, cantidad);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 4:
                       int precio = Integer.parseInt(nuevo_valor_repuesto.getText());
                       cRepuesto = new ControladorRepuesto();
                       result = cRepuesto.cambiarPrecio(id_repuesto, precio);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 5:
                       int iva = Integer.parseInt(nuevo_valor_repuesto.getText());
                       cRepuesto = new ControladorRepuesto();
                       result = cRepuesto.cambiarIva(id_repuesto, iva);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;
                   case 6:
                       int asociar_vehiculo = Integer.parseInt(nuevo_valor_repuesto.getText());
                       ControladorRepuestosDeVehiculo cRV = new ControladorRepuestosDeVehiculo();
                       result = cRV.insertarVinculo(id_repuesto, asociar_vehiculo);
                       if ((result == -2) | (result == -3)) {
                           JOptionPane.showMessageDialog(rootPane, "OCURRIO UN PROBLEMA CON LA BASE DE DATOS, CONTACTE CON SOPORTE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                       }
                       else {
                           JOptionPane.showMessageDialog(rootPane, "SE HA MODIFICADO CON EXITO", "AutosABC", JOptionPane.INFORMATION_MESSAGE);
                       }
                       break;     
               }
           }
       }
       catch(NumberFormatException e) {
             JOptionPane.showMessageDialog(rootPane, "EL ID DEBEN SER NUMEROS, AL GIUAL QUE\n"
                     + "1) LA SEDE DEL REPUESTO\n2) EL PRECIO DEL REPUESTO\n3) EL IVA DEL REPUESTO\n4) LA CANTIDAD DEL REPUESTO\n5) EL VEHICULO A ASOCIAR, PUES REPRESENTA EL ID DEL MISMO", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_botonModificarRepuestoActionPerformed

    private void boton_consultar_sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_consultar_sedeActionPerformed
       
        ControladorSede cSede = new ControladorSede();
        
        ArrayList<Sede> sedes = cSede.consultarSedes();
        
       int index1 = seleccionarSede.getSelectedIndex();
       int index2 = atributoSede.getSelectedIndex();
       
       if ((index1 == 0)){
           if ((index2 == 0)){
           
           }
           else {
               String informacion ="";
               String valorS = "";
               switch (index2) {
                   case 1:
                        try {
                            int valorI = Integer.parseInt(valor_consulta_sede.getText());
                            informacion = "";
                            areaTextoConsultaSede.setText("");
                            for (int i = 0; i < sedes.size(); i++){
                                if (valorI == sedes.get(i).getId()) {
                                    informacion = "------------------------------------------------------\n" 
                                            + "IDENTIFICACION SEDE: " + sedes.get(i).getId()+ "\n" 
                                            + "NOMBRE SEDE: " + sedes.get(i).getNombre() + "\n" 
                                            + "CIUDAD SEDE: " + sedes.get(i).getCiudad() + "\n" 
                                            + "DIRECION SEDE: " + sedes.get(i).getDireccion() + "\n" 
                                            + "TELEFONO SEDE: " + sedes.get(i).getTelefono() + "\n" 
                                            + "FAX SEDE: " + sedes.get(i).getFax() + "\n"
                                            + "------------------------------------------------------\n" ;
                                    areaTextoConsultaSede.append(informacion);
                                }
                            }
                        }
                        
                        catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(rootPane, "ERROR: EL VALOR DE BUSQUEDA DEBE SER NUMERICO EN ESTE CASO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                       break;
                   case 2:
                       valorS = valor_consulta_sede.getText();
                       informacion = "";
                       areaTextoConsultaSede.setText("");
                       for (int i = 0; i < sedes.size(); i++){
                            if (valorS.equalsIgnoreCase(sedes.get(i).getNombre())) {
                                informacion = "------------------------------------------------------\n" 
                                    + "IDENTIFICACION SEDE: " + sedes.get(i).getId()+ "\n" 
                                    + "NOMBRE SEDE: " + sedes.get(i).getNombre() + "\n" 
                                    + "CIUDAD SEDE: " + sedes.get(i).getCiudad() + "\n" 
                                    + "DIRECION SEDE: " + sedes.get(i).getDireccion() + "\n" 
                                    + "TELEFONO SEDE: " + sedes.get(i).getTelefono() + "\n" 
                                    + "FAX SEDE: " + sedes.get(i).getFax() + "\n"
                                    + "------------------------------------------------------\n" ;
                                areaTextoConsultaSede.append(informacion);
                            }
                       }
                       break;
                   case 3:
                       valorS = valor_consulta_sede.getText();
                       informacion = "";
                       areaTextoConsultaSede.setText("");
                       for (int i = 0; i < sedes.size(); i++){
                            if (valorS.equalsIgnoreCase(sedes.get(i).getCiudad())) {
                                informacion = "------------------------------------------------------\n" 
                                    + "IDENTIFICACION SEDE: " + sedes.get(i).getId()+ "\n" 
                                    + "NOMBRE SEDE: " + sedes.get(i).getNombre() + "\n" 
                                    + "CIUDAD SEDE: " + sedes.get(i).getCiudad() + "\n" 
                                    + "DIRECION SEDE: " + sedes.get(i).getDireccion() + "\n" 
                                    + "TELEFONO SEDE: " + sedes.get(i).getTelefono() + "\n" 
                                    + "FAX SEDE: " + sedes.get(i).getFax() + "\n"
                                    + "------------------------------------------------------\n" ;
                                areaTextoConsultaSede.append(informacion);
                            }
                       }
                       break;
               }
           }
       }
       
       else if (index1 == 1) {
           String informacion = "";
           areaTextoConsultaSede.setText("");
           for (int i = 0; i < sedes.size(); i++){
               informacion = "------------------------------------------------------\n" 
                           + "IDENTIFICACION SEDE: " + sedes.get(i).getId()+ "\n" 
                           + "NOMBRE SEDE: " + sedes.get(i).getNombre() + "\n" 
                           + "CIUDAD SEDE: " + sedes.get(i).getCiudad() + "\n" 
                           + "DIRECION SEDE: " + sedes.get(i).getDireccion() + "\n" 
                           + "TELEFONO SEDE: " + sedes.get(i).getTelefono() + "\n" 
                           + "FAX SEDE: " + sedes.get(i).getFax() + "\n"
                           + "------------------------------------------------------\n" ;
               areaTextoConsultaSede.append(informacion);
           }
       }
       
       else {
           
           String informacion = "";
               informacion = "------------------------------------------------------\n" 
                           + "IDENTIFICACION SEDE: " + sedes.get(index1 - 1).getId()+ "\n" 
                           + "NOMBRE SEDE: " + sedes.get(index1 - 1).getNombre() + "\n" 
                           + "CIUDAD SEDE: " + sedes.get(index1 - 1).getCiudad() + "\n" 
                           + "DIRECION SEDE: " + sedes.get(index1 - 1).getDireccion() + "\n" 
                           + "TELEFONO SEDE: " + sedes.get(index1 - 1).getTelefono() + "\n" 
                           + "FAX SEDE: " + sedes.get(index1 - 1).getFax() + "\n"
                           + "------------------------------------------------------\n" ;
               areaTextoConsultaSede.setText(informacion);

           
       }
       
       
    }//GEN-LAST:event_boton_consultar_sedeActionPerformed

    private void botonConsultarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarUsuarioActionPerformed
       ventanaUsuarios.show(jPanel11, "CONSULTA-USUARIO");
    }//GEN-LAST:event_botonConsultarUsuarioActionPerformed

    private void comboBoxBusquedaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxBusquedaUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxBusquedaUsuarioActionPerformed

    private void boton_consultar_usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_consultar_usuarioActionPerformed
        int index = comboBoxBusquedaUsuario.getSelectedIndex();
        
        ControladorUsuario cU = new ControladorUsuario();
        
        ArrayList<Usuario> usuariosS = cU.consultarUsuarios(); 
        if (index == 0) {
            JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
        }
        
        else if (index == 1) {
            String informacion = "";
            for (int i = 0; i < usuariosS.size(); i++) {
                informacion += "--------------------------------------------------------\n";
                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                informacion += "--------------------------------------------------------\n";
            }
            areaTextoConsultaUsuario.setText(informacion);
        }
        
        else {
            String informacion = "";
            index = index - 2;
            switch(index) {
                
                case 0:
                    try {
                        int cedula = Integer.parseInt(valor_consulta_usuario.getText());
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (cedula == usuariosS.get(i).getCedula()) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 1:
                    try {
                        int sede = Integer.parseInt(valor_consulta_usuario.getText());
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (sede == usuariosS.get(i).getSede()) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 2:
                    try {
                        String nombre = valor_consulta_usuario.getText();
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getNombre().contains(nombre)) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 3:
                    try {
                        char genero = valor_consulta_usuario.getText().charAt(0);
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getGenero() == genero) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(rootPane, "NO SE PERMITEN CAMPOS VACIOS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 4:
                    if (valor_consulta_usuario.getText().equalsIgnoreCase("GERENTE")) {
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getCargo() == 1) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: GERENTE \n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    
                    else if (valor_consulta_usuario.getText().equalsIgnoreCase("VENDEDOR")) {
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getCargo() == 3) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: VENDEDOR \n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    
                    else if(valor_consulta_usuario.getText().equalsIgnoreCase("JEFE DE TALLER")) {
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getCargo() == 2) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: JEFE DE TALLER \n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "ESTE CAMPO SÓLO ADMITE 3 VALORES DE BUSQUEDA: \n 1) GERENTE\n2) VENDEDOR\n 3) JEFE DE TALLER", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 5:
                    try {
                        String formato = valor_consulta_usuario.getText();
                        informacion = "";
                        if ((formato.charAt(0) == '>') && (formato.charAt(1) == '=')) {
                            String numero = "";
                            for (int i = 2; i < formato.length(); i++){
                                numero += formato.charAt(i);
                            }
                            int valor = Integer.parseInt(numero);
                            for (int i = 0; i < usuariosS.size(); i++) {
                                if (usuariosS.get(i).getSalario() >= valor) {
                                    informacion += "--------------------------------------------------------\n";
                                    informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                    informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                    informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                    informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                    informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                    informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                    informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                    informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                    informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                    informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                    informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaUsuario.setText(informacion);
                        }
                        else if ((formato.charAt(0) == '<') && (formato.charAt(1) == '=')) {
                            String numero = "";
                            for (int i = 2; i < formato.length(); i++){
                                numero += formato.charAt(i);
                            }
                            int valor = Integer.parseInt(numero);
                            for (int i = 0; i < usuariosS.size(); i++) {
                                if (usuariosS.get(i).getSalario() <= valor) {
                                    informacion += "--------------------------------------------------------\n";
                                    informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                    informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                    informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                    informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                    informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                    informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                    informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                    informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                    informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                    informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                    informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaUsuario.setText(informacion);
                        }
                        
                        else if ((formato.charAt(0) == '=') && (formato.charAt(1) == '=')) {
                            String numero = "";
                            for (int i = 2; i < formato.length(); i++){
                                numero += formato.charAt(i);
                            }
                            int valor = Integer.parseInt(numero);
                            for (int i = 0; i < usuariosS.size(); i++) {
                                if (usuariosS.get(i).getSalario() == valor) {
                                    informacion += "--------------------------------------------------------\n";
                                    informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                    informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                    informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                    informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                    informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                    informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                    informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                    informacion += "CARGO DEL USUARIO: " + usuariosS.get(i).getCargo() + "\n";
                                    informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                    informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                    informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaUsuario.setText(informacion);
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, DEBE ANTERPONER ANTES DEL NUMERO:\n 1) '>=' PARA SALARIOS MAYORES O IGUALES AL INGRESADO\n 2) '<=' PARA SALARIOS MENORES O IGUALES AL INGRESADO\n 3) '==' PARA VALORES ESTRICTAMENTE IGUALES AL INGRESADO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        
                    }
                    catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(rootPane, "EL SALARIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    catch (StringIndexOutOfBoundsException e) {
                        JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, DEBE ANTERPONER ANTES DEL NUMERO:\n 1) '>=' PARA SALARIOS MAYORES O IGUALES AL INGRESADO\n 2) '<=' PARA SALARIOS MENORES O IGUALES AL INGRESADO\n 3) '==' PARA VALORES ESTRICTAMENTE IGUALES AL INGRESADO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case 6:
                    if (valor_consulta_usuario.getText().equalsIgnoreCase("ACTIVO")) {
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getEstado().equalsIgnoreCase("ACTIVO")) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: GERENTE \n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    
                    else if (valor_consulta_usuario.getText().equalsIgnoreCase("INACTIVO")) {
                        informacion = "";
                        for (int i = 0; i < usuariosS.size(); i++) {
                            if (usuariosS.get(i).getEstado().equalsIgnoreCase("INACTIVO")) {
                                informacion += "--------------------------------------------------------\n";
                                informacion += "CEDULA USUARIO: " + usuariosS.get(i).getCedula() + "\n";
                                informacion += "SEDE DONDE LABORA: " + usuariosS.get(i).getSede()+ "\n";
                                informacion += "NOMBRE USUARIO: " + usuariosS.get(i).getNombre() + "\n";
                                informacion += "FECHA DE NACIMIENTO: " + usuariosS.get(i).getFecha() + "\n";
                                informacion += "DIRECCION DEL USUARIO: " + usuariosS.get(i).getDireccion() + "\n";
                                informacion += "GENERO DEL USUARIO: " + usuariosS.get(i).getGenero() + "\n";
                                informacion += "EMAIL DEL USUARIO: " + usuariosS.get(i).getEmail() + "\n";
                                informacion += "CARGO DEL USUARIO: VENDEDOR \n";
                                informacion += "SALARIO DEL USUARIO: " + usuariosS.get(i).getSalario() + "\n";
                                informacion += "TELEFONO DEL USUARIO: " + usuariosS.get(i).getTelefono() + "\n";
                                informacion += "ESTADO DEL USUARIO: " + usuariosS.get(i).getEstado() + "\n";
                                informacion += "--------------------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaUsuario.setText(informacion);
                    }
                    else {
                        JOptionPane.showMessageDialog(rootPane, "ESTE CAMPO SÓLO ADMITE 2 VALORES DE BUSQUEDA: \n 1) ACTIVO\n2) INACTIVO\n", "AutosABC", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
        }
    }//GEN-LAST:event_boton_consultar_usuarioActionPerformed

    private void botonConsultarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultarInventarioActionPerformed
       ventanaInventario.show(jPanel13, "CONSULTA-INVENTARIO");
    }//GEN-LAST:event_botonConsultarInventarioActionPerformed

    private void boton_consultar_inventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_consultar_inventarioActionPerformed
       if (radioBotonVehiculo.isSelected()){
           ControladorVehiculo cV = new ControladorVehiculo();
           
           ArrayList<Vehiculo>  vehiculosI = cV.consultarVehiculos2();
           
           int index = comboBosBusquedaInventario.getSelectedIndex();
           if (index == 0){
               JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           else if(index == 1) {
               String informacion = "";
               for (int i = 0; i < vehiculosI.size(); i++){
                   informacion += "--------------------------------------------\n";
                   informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                   informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                   informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                   informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                   informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                   informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                   informacion += "TRACCION DEL VEHICULO: " + vehiculosI.get(i).getTraccion() + "\n";
                   informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                   informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                   informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                   informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                   informacion += "--------------------------------------------\n";
               }
               areaTextoConsultaInventario.setText(informacion);
           }
           else {
                index = index - 2;
                String informacion = "";
                switch (index) {
                    case 0:
                        try {
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (id == vehiculosI.get(i).getVehiculo()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE CONSULTA DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (id == vehiculosI.get(i).getId_sede()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE CONSULTA DEBE SER NUMERICO,\nYA QUE REPRESENTA LA IDENTIFICACION DE LA SEDE", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                            String color = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getColor().equalsIgnoreCase(color)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 3:
                            String marca = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getMarca().equalsIgnoreCase(marca)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 4:
                        String referencia = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getReferencia().equalsIgnoreCase(referencia)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 5:
                        String tipo = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getTipo().equalsIgnoreCase(tipo)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 6:
                        String traccion = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getTraccion().equalsIgnoreCase(traccion)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 7:
                        try {
                            String modelo = Integer.toString(Integer.parseInt(valor_consulta_inventario.getText()));
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getModelo().equalsIgnoreCase(modelo)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE CONSULTA DEBE SER NUMERICO,\nYA QUE REPRESENTA EL AÑO DEL VEHICULO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 8:
                        String formato = valor_consulta_inventario.getText();
                        
                        if ((formato.charAt(0) == '>') && (formato.charAt(1) == '=')) {
                            try {
                                String precio = "";
                                
                                for (int i = 2; i < formato.length(); i++) {
                                    precio += formato.charAt(i);
                                }
                                
                                int valor = Integer.parseInt(precio);

                                informacion = "";
                                for (int i = 0; i < vehiculosI.size(); i++){
                                    if (vehiculosI.get(i).getPrecio() >= valor) {
                                        informacion += "--------------------------------------------\n";
                                        informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                        informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                        informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                        informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                        informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                        informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                        informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                        informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                        informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                        informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                        informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            catch(NumberFormatException e) {
                                JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else  if((formato.charAt(0) == '<') && (formato.charAt(1) == '=')) {
                            try {
                                String precio = "";
                                
                                for (int i = 2; i < formato.length(); i++) {
                                    precio += formato.charAt(i);
                                }
                                
                                int valor = Integer.parseInt(precio);

                                informacion = "";
                                for (int i = 0; i < vehiculosI.size(); i++){
                                    if (vehiculosI.get(i).getPrecio() <= valor) {
                                        informacion += "--------------------------------------------\n";
                                        informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                        informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                        informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                        informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                        informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                        informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                        informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                        informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                        informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                        informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                        informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            catch(NumberFormatException e) {
                                JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                        
                        }
                        else if ((formato.charAt(0) == '=') && (formato.charAt(1) == '=')) {
                            try {
                                String precio = "";
                                
                                for (int i = 2; i < formato.length(); i++) {
                                    precio += formato.charAt(i);
                                }
                                
                                int valor = Integer.parseInt(precio);

                                informacion = "";
                                for (int i = 0; i < vehiculosI.size(); i++){
                                    if (valor == vehiculosI.get(i).getPrecio()) {
                                        informacion += "--------------------------------------------\n";
                                        informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                        informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                        informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                        informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                        informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                        informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                        informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                        informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                        informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                        informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                        informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            catch(NumberFormatException e) {
                                JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(rootPane, "FORMATO DE CONSULTA INVALIDO, RECUERDE QUE EL PRECIO DEBE SER NUMERICO Y ADEMÁS PONER ANTES DEL PRECIO:\n"
                                    + "1) PONER '>=' PARA CONSULTAR PRECIOS MAYORES O IGUALES AL INGRESADO\n"
                                    + "2) PONER '<=' PARA CONSULTAR PRECIOS MENORES O IGUALES AL INGRESADO\n"
                                    + "3) PONER '==' PARA CONSULTAR PRECIOS ESTRICTAMENTE IGUALES AL INGRESADO\n", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 9:
                            String estado = valor_consulta_inventario.getText();
                            
                            informacion = "";
                            for (int i = 0; i < vehiculosI.size(); i++){
                                if (vehiculosI.get(i).getEstado().equalsIgnoreCase(estado)) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION VEHICULO: " + vehiculosI.get(i).getVehiculo() + "\n";
                                    informacion += "SEDE VEHICULO: " + vehiculosI.get(i).getId_sede() + "\n";
                                    informacion += "COLOR DEL VEHICULO: " + vehiculosI.get(i).getColor()+ "\n";
                                    informacion += "MARCA DEL VEHICULO: " + vehiculosI.get(i).getMarca()+ "\n";
                                    informacion += "REFERENCIA DEL VEHICULO: " + vehiculosI.get(i).getReferencia()+ "\n";
                                    informacion += "TIPO DEL VEHICULO: " + vehiculosI.get(i).getTipo() + "\n";
                                    informacion += "TRACCION DEL VEHICULO:   " + vehiculosI.get(i).getTraccion() + "\n";
                                    informacion += "MODELO DEL VEHICULO: " + vehiculosI.get(i).getModelo() + "\n";
                                    informacion += "PRECIO DLE VEHICULO: " + vehiculosI.get(i).getPrecio() + "\n";
                                    informacion += "IVA DEL VEHICULO: " + vehiculosI.get(i).getIva() + "\n";
                                    informacion += "ESTADO DEL VEHICULO: " + vehiculosI.get(i).getEstado() + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                }
           }
       }
       else if(radioBotonRepuesto.isSelected()) {
           
           ControladorRepuesto cR = new ControladorRepuesto();
           
           ArrayList<Repuesto> repuestosI = cR.consultarRepuestos();
           
           int index = comboBosBusquedaInventario.getSelectedIndex();
           if (index == 0){
               JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           else if(index == 1) {
               String informacion = "";
               for (int i = 0; i < repuestosI.size(); i++){
                   informacion += "--------------------------------------------\n";
                   informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                   informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                   informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                   informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                   informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                   informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                   informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                   informacion += "--------------------------------------------\n";
               }
               areaTextoConsultaInventario.setText(informacion);
           }
           else {
               String informacion = "";
                index = index - 2;
                switch (index) {
                    case 0:
                        try {
                            informacion = "";
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            for (int i = 0; i < repuestosI.size(); i++){
                                if (id == repuestosI.get(i).getId_repuesto()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                    informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                    informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                    informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                    informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                    informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                    informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE CONSULTA DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                            informacion = "";
                            int sede = Integer.parseInt(valor_consulta_inventario.getText());
                            for (int i = 0; i < repuestosI.size(); i++){
                                if (sede == repuestosI.get(i).getId_sede()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                    informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                    informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                    informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                    informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                    informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                    informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE CONSULTA DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                            informacion = "";
                            String nombre = valor_consulta_inventario.getText();
                            for (int i = 0; i < repuestosI.size(); i++){
                                if (repuestosI.get(i).getNombre().equalsIgnoreCase(nombre)){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                    informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                    informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                    informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                    informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                    informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                    informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 3:
                        String formato = valor_consulta_inventario.getText();
                        
                        if (formato.equals("")) {
                            JOptionPane.showMessageDialog(rootPane, "ERROR: CAMPO VACIO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        
                        else {
                            if ((formato.charAt(0) == '>') && (formato.charAt(1) == '=')) {
                                try {
                                    String precio = "";

                                    for (int i = 2; i < formato.length(); i++) {
                                        precio += formato.charAt(i);
                                    }

                                    int valor = Integer.parseInt(precio);

                                    informacion = "";
                                    for (int i = 0; i < repuestosI.size(); i++){
                                        if (repuestosI.get(i).getPrecio_unidad() >= valor) {
                                            informacion += "--------------------------------------------\n";
                                            informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                            informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                            informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                            informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                            informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                            informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                            informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                            informacion += "--------------------------------------------\n";
                                        }
                                    }
                                    areaTextoConsultaInventario.setText(informacion);
                                }
                                catch(NumberFormatException e) {
                                    JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else  if((formato.charAt(0) == '<') && (formato.charAt(1) == '=')) {
                                try {
                                    String precio = "";

                                    for (int i = 2; i < formato.length(); i++) {
                                        precio += formato.charAt(i);
                                    }

                                    int valor = Integer.parseInt(precio);

                                    informacion = "";
                                    for (int i = 0; i < repuestosI.size(); i++){
                                        if (repuestosI.get(i).getPrecio_unidad() <= valor) {
                                            informacion += "--------------------------------------------\n";
                                            informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                            informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                            informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                            informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                            informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                            informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                            informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                            informacion += "--------------------------------------------\n";
                                        }
                                    }
                                    areaTextoConsultaInventario.setText(informacion);
                                }
                                catch(NumberFormatException e) {
                                    JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                                }

                            }
                            else if ((formato.charAt(0) == '=') && (formato.charAt(1) == '=')) {
                                try {
                                    String precio = "";

                                    for (int i = 2; i < formato.length(); i++) {
                                        precio += formato.charAt(i);
                                    }

                                    int valor = Integer.parseInt(precio);

                                    informacion = "";
                                    for (int i = 0; i < repuestosI.size(); i++){
                                        if (valor == repuestosI.get(i).getPrecio_unidad()) {
                                            informacion += "--------------------------------------------\n";
                                            informacion += "IDENTIFICACION REPUESTO: " + repuestosI.get(i).getId_repuesto()+ "\n";
                                            informacion += "SEDE REPUESTO: " + repuestosI.get(i).getId_sede()+ "\n";
                                            informacion += "NOMBRE REPUESTO: " + repuestosI.get(i).getNombre()+ "\n";
                                            informacion += "CANTIDAD REPUESTO: " + repuestosI.get(i).getCantidad()+ "\n";
                                            informacion += "PRECIO REPUESTO: " + repuestosI.get(i).getPrecio_unidad()+ "\n";
                                            informacion += "IVA REPUESTO: " + repuestosI.get(i).getIva()+ "\n";
                                            informacion += "DESCRIPCION REPUESTO: " + repuestosI.get(i).getDescripcion()+ "\n";
                                            informacion += "--------------------------------------------\n";
                                        }
                                    }
                                    areaTextoConsultaInventario.setText(informacion);
                                }
                                catch(NumberFormatException e) {
                                    JOptionPane.showMessageDialog(rootPane, "EL PRECIO DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(rootPane, "FORMATO DE CONSULTA INVALIDO, RECUERDE QUE EL PRECIO DEBE SER NUMERICO Y ADEMÁS PONER ANTES DEL PRECIO:\n"
                                        + "1) PONER '>=' PARA CONSULTAR PRECIOS MAYORES O IGUALES AL INGRESADO\n"
                                        + "2) PONER '<=' PARA CONSULTAR PRECIOS MENORES O IGUALES AL INGRESADO\n"
                                        + "3) PONER '==' PARA CONSULTAR PRECIOS ESTRICTAMENTE IGUALES AL INGRESADO\n", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                }
           }
       }
       else if(radioBotonVenta.isSelected()) {
           ControladorVenta cV = new ControladorVenta();
           ControladorVehiculo cV2 = new ControladorVehiculo();
           
           ArrayList<Venta> ventasI = cV.consultarVentas();
           ArrayList<Vehiculo> vehiculosI = cV2.consultarVehiculos2();
           
           int index = comboBosBusquedaInventario.getSelectedIndex();
           if (index == 0){
               JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           else if(index == 1) {
               String informacion = "";
               for (int i = 0; i < ventasI.size(); i++){
                   informacion += "--------------------------------------------\n";
                   informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                   informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                   informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                   informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                   informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                   informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                   informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                   informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                   informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                   int precio = 0;
                   for (int j = 0; j < vehiculosI.size(); j++) {
                       if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                           precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                       }
                   }
                   informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                   informacion += "--------------------------------------------\n";
               }
               areaTextoConsultaInventario.setText(informacion);
           }
           else {
                index = index - 2;
                String informacion = "";
                switch (index) {
                    case 0:
                        try {
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                if (id == ventasI.get(i).getId_venta()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                            int vehiculo = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                if (vehiculo == ventasI.get(i).getId_vehiculo()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        try {
                            int usuario = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                if (usuario == ventasI.get(i).getId_usuario()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        try {
                            int sede = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                if (sede == ventasI.get(i).getId_sede()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        String formaPago = valor_consulta_inventario.getText();
                        informacion = "";
                        for (int i = 0; i < ventasI.size(); i++){
                            if (ventasI.get(i).getForma_pago().equalsIgnoreCase(formaPago)) {
                                informacion += "--------------------------------------------\n";
                                informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                int precio = 0;
                                for (int j = 0; j < vehiculosI.size(); j++) {
                                    if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                         precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                    }
                                }
                                informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                informacion += "--------------------------------------------\n";
                            }
                        }
                        areaTextoConsultaInventario.setText(informacion);
                        break;
                    case 5:
                        try {
                            int año = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(ventasI.get(i).getFecha());
                                int year = cal.get(Calendar.YEAR);
                                if (year == año) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 6:
                        try {
                            int mes = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(ventasI.get(i).getFecha());
                                int month = cal.get(Calendar.MONTH) + 1;
                                if (month == mes) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 7:
                        try {
                            int dia = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ventasI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(ventasI.get(i).getFecha());
                                int day = cal.get(Calendar.DAY_OF_MONTH);
                                if (day == dia) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                    informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                    informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                    informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                    informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                    informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 8:
                        try {
                            String fecha = valor_consulta_inventario.getText();
                            if ((fecha.charAt(4) == '/') && (fecha.charAt(7) == '/')){
                                String añoS = "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
                                String mesS = "" + fecha.charAt(5) + fecha.charAt(6);
                                String diaS = "" + fecha.charAt(8) + fecha.charAt(9);
                                int año = Integer.parseInt(añoS);
                                int mes = Integer.parseInt(mesS);
                                int dia = Integer.parseInt(diaS);
                                informacion = "";
                                for (int i = 0; i < ventasI.size(); i++){
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(ventasI.get(i).getFecha());
                                    int year = cal.get(Calendar.YEAR);
                                    int month = cal.get(Calendar.MONTH) + 1;
                                    int day = cal.get(Calendar.DAY_OF_MONTH);
                                    if ((day == dia) && (month == mes) && (año == year)) {
                                        informacion += "--------------------------------------------\n";
                                        informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                        informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                        informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                        informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                        informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                        informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                        informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                        informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                        informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                        int precio = 0;
                                        for (int j = 0; j < vehiculosI.size(); j++) {
                                            if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                                precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                            }
                                        }
                                        informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            
                            else {
                                JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM / DD", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        }
                        catch(StringIndexOutOfBoundsException e){
                            JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM / DD", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "LA FECHA ESTA COMPUSTA DE NUMEROS, NO DE LETRAS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 9:
                        try {
                            String fecha = valor_consulta_inventario.getText();
                            if (fecha.charAt(4) == '/'){
                                String añoS = "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
                                String mesS = "" + fecha.charAt(5) + fecha.charAt(6);
                                int año = Integer.parseInt(añoS);
                                int mes = Integer.parseInt(mesS);
                                informacion = "";
                                for (int i = 0; i < ventasI.size(); i++){
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(ventasI.get(i).getFecha());
                                    int year = cal.get(Calendar.YEAR);
                                    int month = cal.get(Calendar.MONTH) + 1;
                                    if ((month == mes) && (año == year)) {
                                        informacion += "--------------------------------------------\n";
                                        informacion += "IDENTIFICACION DE LA VENTA: " + ventasI.get(i).getId_venta()+ "\n";
                                        informacion += "VEHICULO VENDIDO: " + ventasI.get(i).getId_vehiculo()+ "\n";
                                        informacion += "CEDULA VENDEDOR: " + ventasI.get(i).getId_usuario()+ "\n";
                                        informacion += "SEDE DE LA VENTA: " + ventasI.get(i).getId_sede()+ "\n";
                                        informacion += "FECHA DE LA VENTA: " + ventasI.get(i).getFecha()+ "\n";
                                        informacion += "FORMA DE PAGO: " + ventasI.get(i).getForma_pago()+ "\n";
                                        informacion += "CEDULA COMPRADOR: " + ventasI.get(i).getCedula_cliente()+ "\n";
                                        informacion += "NOMBRE COMPRADOR: " + ventasI.get(i).getNombre_cliente()+ "\n";
                                        informacion += "TELEFONO COMPRADOR: " + ventasI.get(i).getTelefono_cliente()+ "\n";
                                        int precio = 0;
                                        for (int j = 0; j < vehiculosI.size(); j++) {
                                            if (ventasI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                                precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                            }
                                        }
                                        informacion += "PRECIO DE LA VENTA: " + precio + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            
                            else {
                               JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }  
                            
                        }
                        catch(StringIndexOutOfBoundsException e){
                            JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "LA FECHA ESTA COMPUSTA DE NUMEROS, NO DE LETRAS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
           }
       }
       else if (radioBotonCotizacion.isSelected()) {
           ControladorCotizacion cC = new ControladorCotizacion();
           ControladorVehiculo cV = new ControladorVehiculo();
           
           ArrayList<Cotizacion> cotizacionesI = cC.consultarCotizaciones();
           ArrayList<Vehiculo> vehiculosI;
           vehiculosI = cV.consultarVehiculos2();
           
           int index = comboBosBusquedaInventario.getSelectedIndex();
           if (index == 0){
               JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           else if(index == 1) {
               String informacion = "";
               for (int i = 0; i < cotizacionesI.size(); i++){
                   informacion += "--------------------------------------------\n";
                   informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                   informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                   informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                   informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                   informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                   int precio = 0;
                   for (int j = 0; j < vehiculosI.size(); j++) {
                       if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                           precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                       }
                   }
                   informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                   informacion += "--------------------------------------------\n";
               }
               areaTextoConsultaInventario.setText(informacion);
           }
           else {
               String informacion = "";
                index = index - 2;
                switch (index) {
                    case 0:
                        try {
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                if (id == cotizacionesI.get(i).getId_cotizacion()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "EL VALOR DE BUSQUEDA DEBE SER NUMERICO EN ESTE CASO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                            int vehiculo = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                if (vehiculo == cotizacionesI.get(i).getId_vehiculo()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "EL VALOR DE BUSQUEDA DEBE SER NUMERICO EN ESTE CASO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        try {
                            int cedula = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                if (cedula == cotizacionesI.get(i).getId_usuario()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "EL VALOR DE BUSQUEDA DEBE SER NUMERICO EN ESTE CASO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        try {
                            int sede = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                if (sede == cotizacionesI.get(i).getId_sede()) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "EL VALOR DE BUSQUEDA DEBE SER NUMERICO EN ESTE CASO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        try {
                            int año = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(cotizacionesI.get(i).getFecha());
                                int year = cal.get(Calendar.YEAR);
                                if (year == año) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 5:
                        try {
                            int mes = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(cotizacionesI.get(i).getFecha());
                                int month = cal.get(Calendar.MONTH) + 1;
                                if (month == mes) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 6:
                        try {
                            int dia = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < cotizacionesI.size(); i++){
                                Calendar cal = Calendar.getInstance();
                                cal.setTime(cotizacionesI.get(i).getFecha());
                                int day = cal.get(Calendar.DAY_OF_MONTH);
                                if (day == dia) {
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                    informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                    informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                    informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                    int precio = 0;
                                    for (int j = 0; j < vehiculosI.size(); j++) {
                                        if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                            precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                        }
                                    }
                                    informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DEBE SER NUMERICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 7:
                        try {
                            String fecha = valor_consulta_inventario.getText();
                            if ((fecha.charAt(4) == '/') && (fecha.charAt(7) == '/')){
                                String añoS = "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
                                String mesS = "" + fecha.charAt(5) + fecha.charAt(6);
                                String diaS = "" + fecha.charAt(8) + fecha.charAt(9);
                                int año = Integer.parseInt(añoS);
                                int mes = Integer.parseInt(mesS);
                                int dia = Integer.parseInt(diaS);
                                informacion = "";
                                for (int i = 0; i < cotizacionesI.size(); i++){
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(cotizacionesI.get(i).getFecha());
                                    int year = cal.get(Calendar.YEAR);
                                    int month = cal.get(Calendar.MONTH) + 1;
                                    int day = cal.get(Calendar.DAY_OF_MONTH);
                                    if ((day == dia) && (month == mes) && (año == year)) {
                                        informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                        informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                        informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                        informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                        informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                        int precio = 0;
                                        for (int j = 0; j < vehiculosI.size(); j++) {
                                            if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                                precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                            }
                                        }
                                        informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            
                            else {
                                JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM / DD", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }
                            
                        }
                        catch(StringIndexOutOfBoundsException e){
                            JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM / DD", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "LA FECHA ESTA COMPUSTA DE NUMEROS, NO DE LETRAS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 8:
                        try {
                            String fecha = valor_consulta_inventario.getText();
                            if (fecha.charAt(4) == '/'){
                                String añoS = "" + fecha.charAt(0) + fecha.charAt(1) + fecha.charAt(2) + fecha.charAt(3);
                                String mesS = "" + fecha.charAt(5) + fecha.charAt(6);
                                int año = Integer.parseInt(añoS);
                                int mes = Integer.parseInt(mesS);
                                informacion = "";
                                for (int i = 0; i < cotizacionesI.size(); i++){
                                    Calendar cal = Calendar.getInstance();
                                    cal.setTime(cotizacionesI.get(i).getFecha());
                                    int year = cal.get(Calendar.YEAR);
                                    int month = cal.get(Calendar.MONTH) + 1;
                                    if ((month == mes) && (año == year)) {
                                        informacion += "IDENTIFICACION DE LA COTIZACION: " + cotizacionesI.get(i).getId_cotizacion()+ "\n";
                                        informacion += "VEHICULO COTIZADO: " + cotizacionesI.get(i).getId_vehiculo()+ "\n";
                                        informacion += "CEDULA VENDEDOR: " + cotizacionesI.get(i).getId_usuario()+ "\n";
                                        informacion += "SEDE DE LA COTIZACION: " + cotizacionesI.get(i).getId_sede()+ "\n";
                                        informacion += "FECHA DE LA COTIZACION: " + cotizacionesI.get(i).getFecha()+ "\n";
                                        int precio = 0;
                                        for (int j = 0; j < vehiculosI.size(); j++) {
                                            if (cotizacionesI.get(i).getId_vehiculo() == vehiculosI.get(j).getVehiculo()){
                                                precio = vehiculosI.get(j).getPrecio() + vehiculosI.get(j).getIva();
                                            }
                                        }
                                        informacion += "PRECIO DE LA COTIZACION: " + precio + "\n";
                                        informacion += "--------------------------------------------\n";
                                    }
                                }
                                areaTextoConsultaInventario.setText(informacion);
                            }
                            
                            else {
                                JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM", "AutosABC", JOptionPane.ERROR_MESSAGE);
                            }                          
                        }
                        catch(StringIndexOutOfBoundsException e){
                            JOptionPane.showMessageDialog(rootPane, "FORMATO INCORRECTO, ESTE CAMPO DEBE SEGUIR LA SIGUIENTE ESTRUCTURA: AAAA / MM", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        catch(NumberFormatException e){
                            JOptionPane.showMessageDialog(rootPane, "LA FECHA ESTA COMPUSTA DE NUMEROS, NO DE LETRAS", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
           }
       }
       else if(radioBotonOrden.isSelected()) {
           ControladorOrdenDeTrabajo cR = new ControladorOrdenDeTrabajo();
           
           ArrayList<OrdenDeTrabajo> ordenesI = cR.consultarOrdenes();
           
           int index = comboBosBusquedaInventario.getSelectedIndex();
           if (index == 0){
               JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UNA BUSQUEDA", "AutosABC", JOptionPane.ERROR_MESSAGE);
           }
           else if(index == 1) {
               String informacion = "";
               for (int i = 0; i < ordenesI.size(); i++){
                   informacion += "--------------------------------------------\n";
                   informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                   informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                   informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                   informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                   informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                   informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                   informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                   informacion += "--------------------------------------------\n";
               }
               areaTextoConsultaInventario.setText(informacion);
           }
           else {
               String informacion = "";
                index = index - 2;
                switch (index) {
                    case 0:
                        try {
                            int id = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ordenesI.size(); i++){
                                if (id == ordenesI.get(i).getId_repuesto()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                                    informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                                    informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                                    informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE BUSQUEDA DEBE SER NUEMRICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        try {
                            int cedula = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ordenesI.size(); i++){
                                if (cedula == ordenesI.get(i).getId_usuario()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                                    informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                                    informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                                    informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE BUSQUEDA DEBE SER NUEMRICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        try {
                            int repuesto = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ordenesI.size(); i++){
                                if (repuesto == ordenesI.get(i).getId_repuesto()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                                    informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                                    informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                                    informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE BUSQUEDA DEBE SER NUEMRICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 3:
                        try {
                            int vehiculo = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ordenesI.size(); i++){
                                if (vehiculo == ordenesI.get(i).getId_vehiculo()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                                    informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                                    informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                                    informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE BUSQUEDA DEBE SER NUEMRICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        try {
                            int sede = Integer.parseInt(valor_consulta_inventario.getText());
                            informacion = "";
                            for (int i = 0; i < ordenesI.size(); i++){
                                if (sede == ordenesI.get(i).getId_sede()){
                                    informacion += "--------------------------------------------\n";
                                    informacion += "IDENTIFICACION DE LA ORDEN: " + ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "CEDULA JEFE DE TALLER: " + ordenesI.get(i).getId_usuario()+ "\n";
                                    informacion += "REPUESTO DE LA ORDEN: " +  ordenesI.get(i).getId_repuesto()+ "\n";
                                    informacion += "VEHICULO IMPLICADO: " + ordenesI.get(i).getId_vehiculo()+ "\n";
                                    informacion += "SEDE DE LA ORDEN: " + ordenesI.get(i).getId_sede()+ "\n";
                                    informacion += "CANTIDAD DEL REPUESTO REQUERIDA: " + ordenesI.get(i).getCantidadRepuesto()+ "\n";
                                    informacion += "DESCRIPCION DE LA ORDEN: " + ordenesI.get(i).getDescripcion()+ "\n";
                                    informacion += "--------------------------------------------\n";
                                }
                            }
                            areaTextoConsultaInventario.setText(informacion);
                        }
                        catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(rootPane, "ESTE VALOR DE BUSQUEDA DEBE SER NUEMRICO", "AutosABC", JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
           }
       }
       else {
           JOptionPane.showMessageDialog(rootPane, "DEBE SELECCIONAR UN ELEMENTO DE CONSULTA", "AutosABC", JOptionPane.ERROR_MESSAGE);
       }
    }//GEN-LAST:event_boton_consultar_inventarioActionPerformed

    private void radioBotonVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonVehiculoActionPerformed
        if (radioBotonVehiculo.isSelected()) {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Busqueda por ...");
            comboBosBusquedaInventario.addItem("Todas");
            comboBosBusquedaInventario.addItem("Identificacion");
            comboBosBusquedaInventario.addItem("Sede");
            comboBosBusquedaInventario.addItem("Color");
            comboBosBusquedaInventario.addItem("Marca");
            comboBosBusquedaInventario.addItem("Referencia");
            comboBosBusquedaInventario.addItem("Tipo");
            comboBosBusquedaInventario.addItem("Traccion");
            comboBosBusquedaInventario.addItem("Modelo");
            comboBosBusquedaInventario.addItem("Precio");
            comboBosBusquedaInventario.addItem("Estado");
            
        }
        else {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Seleccione Consulta");
        }
        radioBotonRepuesto.setSelected(false);
        radioBotonVenta.setSelected(false);
        radioBotonCotizacion.setSelected(false);
        radioBotonOrden.setSelected(false);
    }//GEN-LAST:event_radioBotonVehiculoActionPerformed

    private void radioBotonRepuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonRepuestoActionPerformed
        if (radioBotonRepuesto.isSelected()) {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Busqueda por ...");
            comboBosBusquedaInventario.addItem("Todas");
            comboBosBusquedaInventario.addItem("Identificacion");
            comboBosBusquedaInventario.addItem("Sede");
            comboBosBusquedaInventario.addItem("Nombre");
            comboBosBusquedaInventario.addItem("Precio");
   
        }
        else {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Seleccione Consulta");
        }
        radioBotonVehiculo.setSelected(false);
        radioBotonVenta.setSelected(false);
        radioBotonCotizacion.setSelected(false);
        radioBotonOrden.setSelected(false);
    }//GEN-LAST:event_radioBotonRepuestoActionPerformed

    private void radioBotonVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonVentaActionPerformed
        if (radioBotonVenta.isSelected()) {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Busqueda por ...");
            comboBosBusquedaInventario.addItem("Todas");
            comboBosBusquedaInventario.addItem("Identificacion");
            comboBosBusquedaInventario.addItem("Vehiculo");
            comboBosBusquedaInventario.addItem("Cedula Vendedor");
            comboBosBusquedaInventario.addItem("Sede");
            comboBosBusquedaInventario.addItem("Forma de Pago");
            comboBosBusquedaInventario.addItem("Año");
            comboBosBusquedaInventario.addItem("Mes");
            comboBosBusquedaInventario.addItem("Dia");
            comboBosBusquedaInventario.addItem("Años / Mes / Dia");
            comboBosBusquedaInventario.addItem("Año / Mes");
            
        }
        else {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Seleccione Consulta");
        }
        radioBotonRepuesto.setSelected(false);
        radioBotonVehiculo.setSelected(false);
        radioBotonCotizacion.setSelected(false);
        radioBotonOrden.setSelected(false);
    }//GEN-LAST:event_radioBotonVentaActionPerformed

    private void radioBotonCotizacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonCotizacionActionPerformed
        if (radioBotonCotizacion.isSelected()) {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Busqueda por ...");
            comboBosBusquedaInventario.addItem("Todas");
            comboBosBusquedaInventario.addItem("Identificacion");
            comboBosBusquedaInventario.addItem("Vehiculo");
            comboBosBusquedaInventario.addItem("Cedula Vendedor");
            comboBosBusquedaInventario.addItem("Sede");
            comboBosBusquedaInventario.addItem("Año");
            comboBosBusquedaInventario.addItem("Mes");
            comboBosBusquedaInventario.addItem("Dia");
            comboBosBusquedaInventario.addItem("Años/Mes/Dia");
            comboBosBusquedaInventario.addItem("Año/Mes");
            
        }
        else {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Seleccione Consulta");
        }
        radioBotonRepuesto.setSelected(false);
        radioBotonVehiculo.setSelected(false);
        radioBotonVenta.setSelected(false);
        radioBotonOrden.setSelected(false);
    }//GEN-LAST:event_radioBotonCotizacionActionPerformed

    private void radioBotonOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBotonOrdenActionPerformed
        if (radioBotonOrden.isSelected()) {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Busqueda por ...");
            comboBosBusquedaInventario.addItem("Todas");
            comboBosBusquedaInventario.addItem("Identificacion");
            comboBosBusquedaInventario.addItem("Cedula Jefe de Taller");
            comboBosBusquedaInventario.addItem("Repuesto");
            comboBosBusquedaInventario.addItem("Vehiculo");
            comboBosBusquedaInventario.addItem("Sede");
            
        }
        else {
            comboBosBusquedaInventario.removeAllItems();
            comboBosBusquedaInventario.addItem("Seleccione Consulta");
        }
        radioBotonRepuesto.setSelected(false);
        radioBotonVehiculo.setSelected(false);
        radioBotonVenta.setSelected(false);
        radioBotonCotizacion.setSelected(false);
    }//GEN-LAST:event_radioBotonOrdenActionPerformed

    private void botonReporte6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporte6ActionPerformed
        campoValorReporte2 = new JTextField("INGRESE EL ID DE LA SEDE");
        JOptionPane.showMessageDialog(rootPane, campoValorReporte2);

        ControladorVenta cV = new ControladorVenta();
        ControladorVehiculo cVh = new ControladorVehiculo();
        ControladorSede cS = new ControladorSede();

        ArrayList<Vehiculo> vehiculosC = cVh.consultarVehiculos2();
        ArrayList<Venta> ventas = cV.consultarVentas();
        ArrayList<Sede> sedes = cS.consultarSedes();
        int venta = 0;
        int sede = 0;
        int result = 0;

        while (result == 0) {
            try {
                sede = Integer.parseInt(campoValorReporte2.getText());
                result = 1;
            }

            catch(NumberFormatException e){
                result = 0;
                campoValorReporte2.setText("DEBE SER UN NUMERO");
                JOptionPane.showMessageDialog(rootPane, campoValorReporte2);
            }
        }
        String informacion = "";

        comboBoxMesReporte1 = new JComboBox();

        comboBoxMesReporte1.addItem("Seleccione un mes");
        comboBoxMesReporte1.addItem("ENERO");
        comboBoxMesReporte1.addItem("FEBRERO");
        comboBoxMesReporte1.addItem("MARZO");
        comboBoxMesReporte1.addItem("ABRIL");
        comboBoxMesReporte1.addItem("MAYO");
        comboBoxMesReporte1.addItem("JUNIO");
        comboBoxMesReporte1.addItem("JULIO");
        comboBoxMesReporte1.addItem("AGOSTO");
        comboBoxMesReporte1.addItem("SEPTIEMBRE");
        comboBoxMesReporte1.addItem("OCTUBRE");
        comboBoxMesReporte1.addItem("NOVIEMBRE");
        comboBoxMesReporte1.addItem("DICIEMBRE");
        comboBoxMesReporte1.addItem("TODOS LOS MESES");

        JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);

        while (comboBoxMesReporte1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);
        }

        if (comboBoxMesReporte1.getSelectedIndex() == 13){

            for (int x = 1; x <= 12; x++){
                for (int i = 0; i < ventas.size(); i++){
                    for (int j = 0; j < vehiculosC.size(); j++){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(ventas.get(i).getFecha());
                        int month = cal.get(Calendar.MONTH) + 1;
                        if ((ventas.get(i).getId_vehiculo() == vehiculosC.get(j).getVehiculo())
                            && (ventas.get(i).getId_sede() == sede)
                            && (month == x)){
                            venta = venta + 1;
                            break;
                        }
                    }
                }

                switch (x){
                    case 1:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ENERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 2:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: FEBRERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 3:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MARZO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 4:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ABRIL\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 5:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MAYO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 6:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JUNIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 7:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JULIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 8:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: AGOSTO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 9:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: SEPTIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 10:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: OCTUBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 11:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: NOVIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 12:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: DICIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                }
                venta = 0;
            }
        }
        else {
            for (int i = 0; i < ventas.size(); i++){
                for (int j = 0; j < vehiculosC.size(); j++){
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(ventas.get(i).getFecha());
                    int month = cal.get(Calendar.MONTH) + 1;
                    if ((ventas.get(i).getId_vehiculo() == vehiculosC.get(j).getVehiculo())
                        && (ventas.get(i).getId_sede() == sede)
                        && (month == comboBoxMesReporte1.getSelectedIndex())){
                        venta = venta + 1;
                        break;
                    }
                }

                switch (comboBoxMesReporte1.getSelectedIndex()){
                    case 1:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ENERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 2:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: FEBRERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 3:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MARZO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 4:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ABRIL\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 5:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MAYO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 6:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JUNIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 7:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JULIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 8:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: AGOSTO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 9:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: SEPTIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 10:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: OCTUBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 11:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: NOVIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 12:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: DICIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                }
            }
        }

        areaTextoReportes.setText(informacion);
        reporteEscogido = 6;
    }//GEN-LAST:event_botonReporte6ActionPerformed

    private void botonReporte5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporte5ActionPerformed
        campoValorReporte2 = new JTextField("INGRESE LA MARCA DEL VEHICULO");
        JOptionPane.showMessageDialog(rootPane, campoValorReporte2);

        ControladorVenta cV = new ControladorVenta();
        ControladorVehiculo cVh = new ControladorVehiculo();

        ArrayList<Vehiculo> vehiculosC = cVh.consultarVehiculos2();
        ArrayList<Venta> ventas = cV.consultarVentas();
        int venta = 0;

        String marca = campoValorReporte2.getText();
        String informacion = "";

        comboBoxMesReporte1 = new JComboBox();

        comboBoxMesReporte1.addItem("Seleccione un mes");
        comboBoxMesReporte1.addItem("ENERO");
        comboBoxMesReporte1.addItem("FEBRERO");
        comboBoxMesReporte1.addItem("MARZO");
        comboBoxMesReporte1.addItem("ABRIL");
        comboBoxMesReporte1.addItem("MAYO");
        comboBoxMesReporte1.addItem("JUNIO");
        comboBoxMesReporte1.addItem("JULIO");
        comboBoxMesReporte1.addItem("AGOSTO");
        comboBoxMesReporte1.addItem("SEPTIEMBRE");
        comboBoxMesReporte1.addItem("OCTUBRE");
        comboBoxMesReporte1.addItem("NOVIEMBRE");
        comboBoxMesReporte1.addItem("DICIEMBRE");
        comboBoxMesReporte1.addItem("TODOS LOS MESES");

        JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);

        while (comboBoxMesReporte1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);
        }

        if (comboBoxMesReporte1.getSelectedIndex() == 13){

            for (int x = 1; x <= 12; x++){
                for (int i = 0; i < ventas.size(); i++){
                    for (int j = 0; j < vehiculosC.size(); j++){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(ventas.get(i).getFecha());
                        int month = cal.get(Calendar.MONTH) + 1;
                        if ((ventas.get(i).getId_vehiculo() == vehiculosC.get(j).getVehiculo())
                            && (vehiculosC.get(j).getMarca().equalsIgnoreCase(marca))
                            && (month == x)){
                            venta = venta + 1;
                            break;
                        }
                    }
                }

                switch (x){
                    case 1:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ENERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 2:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: FEBRERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 3:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MARZO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 4:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ABRIL\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 5:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MAYO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 6:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JUNIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 7:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JULIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 8:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: AGOSTO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 9:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: SEPTIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 10:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: OCTUBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 11:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: NOVIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 12:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: DICIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                }
                venta = 0;
            }
        }
        else {
            for (int i = 0; i < ventas.size(); i++){
                for (int j = 0; j < vehiculosC.size(); j++){
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(ventas.get(i).getFecha());
                    int month = cal.get(Calendar.MONTH) + 1;
                    if ((ventas.get(i).getId_vehiculo() == vehiculosC.get(j).getVehiculo())
                        && (vehiculosC.get(j).getMarca().equalsIgnoreCase(marca))
                        && (month == comboBoxMesReporte1.getSelectedIndex())){
                        venta = venta + 1;
                        break;
                    }
                }

                switch (comboBoxMesReporte1.getSelectedIndex()){
                    case 1:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ENERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 2:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: FEBRERO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 3:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MARZO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 4:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: ABRIL\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 5:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: MAYO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 6:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JUNIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 7:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: JULIO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 8:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: AGOSTO\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 9:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: SEPTIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 10:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: OCTUBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 11:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: NOVIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                    case 12:
                    informacion += "-----------------------------------------\n";
                    informacion += "MES: DICIEMBRE\n";
                    informacion += "NUMERO DE VEHICULOS VENDIDOS: " + venta + "\n";
                    informacion += "-----------------------------------------\n";
                    break;
                }
            }
        }

        areaTextoReportes.setText(informacion);
        reporteEscogido = 5;
    }//GEN-LAST:event_botonReporte5ActionPerformed

    private void botonReporte4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporte4ActionPerformed
        ControladorSede cS = new ControladorSede();
        ControladorVenta cV = new ControladorVenta();
        ControladorVehiculo cVh = new ControladorVehiculo();

        ArrayList<Sede> sedes = cS.consultarSedes();
        ArrayList<Venta> ventas = cV.consultarVentas();
        ArrayList<Vehiculo> vehiculos = cVh.consultarVehiculos2();
        int venta = 0;
        int precio = 0;
        String informacion = "";
        for (int i = 0; i < sedes.size(); i++){
            for (int j = 0; j < ventas.size(); j++){
                if (ventas.get(j).getId_sede() == sedes.get(i).getId()){
                    venta = venta + 1 ;
                    for (int x = 0; x < vehiculos.size(); x++) {
                        if (vehiculos.get(x).getVehiculo() == ventas.get(j).getId_vehiculo()){
                            precio = precio + vehiculos.get(x).getPrecio() + vehiculos.get(x).getIva();
                        }
                    }
                }
            }

            informacion += "-------------------------------------------\n";
            informacion += "ID DE LA SEDE: " + sedes.get(i).getId() +"\n";
            informacion += "TOTAL VEHICULOS VENDIDOS: " + venta +"\n";
            informacion += "TOTAL VENTAS DE LA SEDE: " + precio +"\n";
            informacion += "-------------------------------------------\n";

            venta = 0;
            precio = 0;

        }

        areaTextoReportes.setText(informacion);
        reporteEscogido = 4;
    }//GEN-LAST:event_botonReporte4ActionPerformed

    private void botonReporte3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporte3ActionPerformed
        campoValorReporte2 = new JTextField("INGRESE LA MARCA DEL VEHICULO");
        JOptionPane.showMessageDialog(rootPane, campoValorReporte2);

        ControladorVenta cV = new ControladorVenta();
        ControladorVehiculo cVh = new ControladorVehiculo();

        ArrayList<Vehiculo> vehiculosC = cVh.consultarVehiculos2();
        ArrayList<Venta> ventas = cV.consultarVentas();
        int venta = 0;

        String marca = campoValorReporte2.getText();
        String informacion = "";
        for (int i = 0; i < ventas.size(); i++){
            for (int j = 0; j < vehiculosC.size(); j++){
                if ((ventas.get(i).getId_vehiculo() == vehiculosC.get(j).getVehiculo()) && (vehiculosC.get(j).getMarca().equalsIgnoreCase(marca))){
                    venta = venta + 1;
                }
            }
        }

        informacion = "LA MARCA DE VEHICULO: " + marca + " HA VENDIDO " + venta + " Vehiculos";

        areaTextoReportes.setText(informacion);
        reporteEscogido = 3;
    }//GEN-LAST:event_botonReporte3ActionPerformed

    private void botonReporteNumero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteNumero2ActionPerformed
        campoValorReporte2 = new JTextField("INGRESE LA CEDULA");
        JOptionPane.showMessageDialog(rootPane, campoValorReporte2);
        int result = 0;
        int cedula = 0;

        ControladorUsuario cU = new ControladorUsuario();
        ControladorVenta cV = new ControladorVenta();

        ArrayList<Usuario> usuarios = cU.consultarUsuarios();
        ArrayList<Venta> ventas = cV.consultarVentas();
        int venta = 0;

        while (result == 0) {
            try {
                cedula = Integer.parseInt(campoValorReporte2.getText());
                result = 1;
            }

            catch(NumberFormatException e){
                result = 0;
                campoValorReporte2.setText("DEBE SER UN NUMERO");
                JOptionPane.showMessageDialog(rootPane, campoValorReporte2);
            }
        }
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        String informacion = "";

        for (int i = 0; i < usuarios.size(); i++) {
            if ((usuarios.get(i).getCedula() == cedula) && (usuarios.get(i).getCargo() == 3)) {
                for (int j = 1; j <= 12; j++) {
                    for (int x = 0; x < ventas.size(); x++){
                        Calendar cal2 = Calendar.getInstance();
                        cal2.setTime(ventas.get(x).getFecha());
                        int año = cal2.get(Calendar.YEAR);
                        int mes = cal2.get(Calendar.MONTH) + 1;
                        if ((año == year) && (mes == j) && (ventas.get(x).getId_usuario() == cedula)){
                            venta = venta + 1;
                        }
                    }
                    switch (j) {
                        case 1:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: ENERO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 2:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: FEBRERO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 3:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: MARZO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 4:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: ABRIL\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 5:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: MAYO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 6:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: JUNIO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 7:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES:JULIO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 8:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: AGOSTO\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 9:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: SEPTIEMBRE\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 10:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: OCTUBRE\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 11:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: NOVIEMBRE\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                        case 12:
                        informacion += "-----------------------------------------\n";
                        informacion += "MES: DICIEMBRE\n";
                        informacion += "NUMERO DE VENTAS HECHAS: " + venta + "\n";
                        informacion += "-----------------------------------------\n";
                        break;
                    }
                    venta = 0;
                }
                reporteEscogido = 2;
                break;
            }
            else if((i + 1) == usuarios.size()){
                JOptionPane.showMessageDialog(rootPane, "ESTE USUARIO NO EXISE O NO ES UN VENDEDOR");
            }

        }

        areaTextoReportes.setText(informacion);

    }//GEN-LAST:event_botonReporteNumero2ActionPerformed

    private void botonReporteNumero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonReporteNumero1ActionPerformed
        ControladorUsuario cU = new ControladorUsuario();
        ControladorVenta cV = new ControladorVenta();
        ControladorVehiculo cVh = new ControladorVehiculo();

        ArrayList<Usuario> usuarios = cU.consultarUsuarios();
        ArrayList<Venta> ventas = cV.consultarVentas();
        ArrayList<Vehiculo> vehiculosC = cVh.consultarVehiculos2();
        int venta = 0;
        int precio = 0;

        comboBoxMesReporte1 = new JComboBox();

        comboBoxMesReporte1.addItem("Seleccione un mes");
        comboBoxMesReporte1.addItem("ENERO");
        comboBoxMesReporte1.addItem("FEBRERO");
        comboBoxMesReporte1.addItem("MARZO");
        comboBoxMesReporte1.addItem("ABRIL");
        comboBoxMesReporte1.addItem("MAYO");
        comboBoxMesReporte1.addItem("JUNIO");
        comboBoxMesReporte1.addItem("JULIO");
        comboBoxMesReporte1.addItem("AGOSTO");
        comboBoxMesReporte1.addItem("SEPTIEMBRE");
        comboBoxMesReporte1.addItem("OCTUBRE");
        comboBoxMesReporte1.addItem("NOVIEMBRE");
        comboBoxMesReporte1.addItem("DICIEMBRE");
        comboBoxMesReporte1.addItem("TODOS LOS MESES");

        JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);

        while (comboBoxMesReporte1.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, comboBoxMesReporte1);
        }
        if (comboBoxMesReporte1.getSelectedIndex() == 13){
            String informacion = "";
            for (int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getCargo() == 3) {
                    for (int j=0; j < ventas.size(); j++){
                        if (ventas.get(j).getId_usuario() == usuarios.get(i).getCedula()){
                            venta = venta + 1;
                            for (int x = 0; x < vehiculosC.size(); x++){
                                if (ventas.get(j).getId_vehiculo()== vehiculosC.get(x).getVehiculo()){
                                    precio = precio + vehiculosC.get(x).getPrecio() + vehiculosC.get(x).getIva();
                                }
                            }
                        }
                    }
                }
                informacion += "-------------------------------------------------\n"
                + "CEDULA DLE VENDEDOR: " + usuarios.get(i).getCedula() + "\n"
                + "TOTAL AUTOS VENDEDIDOS: " + venta +  "\n"
                + "TOTAL PRECIO VENTAS: " + precio + "\n"
                + "-------------------------------------------------------\n";
                venta = 0;
                precio = 0;
            }

            areaTextoReportes.setText(informacion);

            reporteEscogido = 1;
        }

        else {
            String informacion = "";
            for (int i = 0; i < usuarios.size(); i++){
                if (usuarios.get(i).getCargo() == 3) {
                    for (int j=0; j < ventas.size(); j++){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(ventas.get(j).getFecha());
                        int mesVenta = cal.get(Calendar.MONTH) + 1;
                        if ((ventas.get(j).getId_usuario() == usuarios.get(i).getCedula()) && (mesVenta == comboBoxMesReporte1.getSelectedIndex())){
                            venta = venta + 1;
                            for (int x = 0; x < vehiculosC.size(); x++){
                                if (ventas.get(j).getId_vehiculo()== vehiculosC.get(x).getVehiculo()){
                                    precio = precio + vehiculosC.get(x).getPrecio() + vehiculosC.get(x).getIva();
                                }
                            }
                        }
                    }
                }
                informacion += "-------------------------------------------------\n"
                + "CEDULA DLE VENDEDOR: " + usuarios.get(i).getCedula() + "\n"
                + "TOTAL AUTOS VENDEDIDOS: " + venta +  "\n"
                + "TOTAL PRECIO VENTAS: " + precio + "\n"
                + "-------------------------------------------------------\n";
                venta = 0;
                precio = 0;
            }

            areaTextoReportes.setText(informacion);

            reporteEscogido = 1;
        }

    }//GEN-LAST:event_botonReporteNumero1ActionPerformed

    private void botonAyudaModificarSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaModificarSedeActionPerformed
        String informacion = "PARA REALIZAR UNA MODIFICACION DEBE PRIMERAMENTE SELECCIONAR UNA SEDE\n"
                + "A LA QUE SE DESEA MODIFCIAR DATOS, LUEGO SE SELECCIONA EL ATRIBUTO QUE SE \n"
                + "DESEA MODIFICAR DE LA SEDE SELECCIONADA Y POR ULTIMO SE DIGITA EL NUEVO VALOR,\n"
                + "TENIENDO EN CUENTA QUE EL TELEFONO Y EL FAX DE UNA SEDE DEBEN SER NUMEROS";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaModificarSedeActionPerformed

    private void botonAyudaConsultaSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaConsultaSedeActionPerformed
        String informacion = "Para consultar una sede, primero seleccione el botón “Sedes” en el menú superior, al cargar el panel de \n"
                + "la izquierda seleccione el botón “Consultar Sede” (el que tiene \n"
                + "un edificio acompañado de una lupa), a continuación en el panel de la derecha deberá \n"
                + "seleccionar la información que desea consultar y digitar la informacion de la sede \n"
                + "de la cual extraer la información.\n\n"
                + "Para poder realizar una consulta satisfactoriamente, se puede consultar o por sedes, o por el atributo de una sede\n"
                + "Pero no por ambos. Si se consulta por una sede se debe especificar si se desea consultar todas las sedes o una\n"
                + "en particular, y se da click en consultar. Si se desea consultar por atributo, entonces la sede debe estar en la\n"
                + "opcion 'Seleccione sede' y despues seleccionar el atributo por el que se desea consultar,\n"
                + "una vez seleccionado el atributo, en el campo de texto se debe ingresar el valor en que debe coincidir\n"
                + "el atributo a la hora de realizar la consulta";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaConsultaSedeActionPerformed

    private void botonAyudaConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAyudaConsultaUsuarioActionPerformed
        String informacion  = "Para realizar consultas de usuarios los pasos son bastantes simples:\n"
                + "Se debe seleccionar el atributo por el que se desea consultar, luego se ingresa en\n"
                + "el campo de texto que valor debe tomar dicho atributo y presionar en consultar,\n"
                + "si se desea consultar toda la informacion de todos los usuarios, entonces se debe\n"
                + "seleccionar la opcion 'Todas' y presionar en consultar.\n\n"
                + "Debe recordar que la cedula y el salario son numeros, no deben ser ni contener \n"
                + "letras o caracteres esoeciales. Además debe tener en cuenta que las consultas\n"
                + "por salario tiene un formato, y es que antes del salario (numero) a consultar\n"
                + "en el campo de etxto debe anteponer un >=, <= o == dependiendo de si quiere consultar\n"
                + "salarios mayores o iguales, menos o iguales o estrictamente iguales al ingresado,\n"
                + "no deben haber espacios en blanco entre el salario y el simbolo.";
        areaAyuda.setText(informacion);
        JOptionPane.showMessageDialog(rootPane, panelAyudas);
    }//GEN-LAST:event_botonAyudaConsultaUsuarioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areTextoModificacionSede;
    private javax.swing.JTextArea areaAyuda;
    private javax.swing.JTextArea areaTextoConsultaInventario;
    private javax.swing.JTextArea areaTextoConsultaSede;
    private javax.swing.JTextArea areaTextoConsultaUsuario;
    private javax.swing.JTextArea areaTextoReportes;
    private javax.swing.JTextArea areaVehiculosAñadidos;
    private javax.swing.JComboBox<String> atributoSede;
    private javax.swing.JButton botonAplicarCambioSede;
    private javax.swing.JButton botonAyudaConsultaSede;
    private javax.swing.JButton botonAyudaConsultaUsuario;
    private javax.swing.JButton botonAyudaCrearSede;
    private javax.swing.JButton botonAyudaCrearUsuario;
    private javax.swing.JButton botonAyudaModificarSede;
    private javax.swing.JButton botonAyudaModificarUsuario;
    private javax.swing.JButton botonAñadirRepuesto;
    private javax.swing.JButton botonAñadirRepuestoVehiculo;
    private javax.swing.JButton botonAñadirVehiculo;
    private javax.swing.JButton botonConsultarInventario;
    private javax.swing.JButton botonConsultarUsuario;
    private javax.swing.JButton botonCrearInventario;
    private javax.swing.JButton botonCrearSede;
    private javax.swing.JButton botonCrearUsuario;
    private javax.swing.JButton botonCrearUsuarioConfirmacion;
    private javax.swing.JButton botonInventarioGerente;
    private javax.swing.JButton botonModificarAtributoUsuario;
    private javax.swing.JButton botonModificarInventario;
    private javax.swing.JButton botonModificarRepuesto;
    private javax.swing.JButton botonModificarSede;
    private javax.swing.JButton botonModificarUsuario;
    private javax.swing.JButton botonModificarVehiculo;
    private javax.swing.JButton botonPanelInventarioCrearRepuesto;
    private javax.swing.JButton botonPanelInventarioCrearVehiculo;
    private javax.swing.JButton botonRefrescarSede;
    private javax.swing.JButton botonReporte3;
    private javax.swing.JButton botonReporte4;
    private javax.swing.JButton botonReporte5;
    private javax.swing.JButton botonReporte6;
    private javax.swing.JButton botonReporteNumero1;
    private javax.swing.JButton botonReporteNumero2;
    private javax.swing.JButton botonReportesGerente;
    private javax.swing.JButton botonSedesGerente;
    private javax.swing.JButton botonUsuariosGerente;
    private javax.swing.JButton boton_consultar_inventario;
    private javax.swing.JButton boton_consultar_sede;
    private javax.swing.JButton boton_consultar_usuario;
    private javax.swing.JTextField cantidad_repuesto;
    private javax.swing.JTextField cantidad_vehiculo;
    private javax.swing.JTextField cedula_modificar_usuario;
    private javax.swing.JTextField cedula_usuario;
    private javax.swing.JTextField ciudad_sede;
    private javax.swing.JTextField color_vehiculo;
    private javax.swing.JComboBox<String> comboBosBusquedaInventario;
    private javax.swing.JComboBox<String> comboBoxAtributoRepuesto;
    private javax.swing.JComboBox<String> comboBoxAtributoUsuario;
    private javax.swing.JComboBox<String> comboBoxAtributoVehiculo;
    private javax.swing.JComboBox<String> comboBoxBusquedaUsuario;
    private javax.swing.JComboBox<String> comboBoxCargoUsuario;
    private javax.swing.JComboBox<String> comboBoxDatoACambiar;
    private javax.swing.JComboBox<String> comboBoxRepuestoVehiculo;
    private javax.swing.JComboBox<String> comboBoxSedeCambio;
    private javax.swing.JComboBox<String> comboBoxSedeCrearUsuario;
    private javax.swing.JComboBox<String> comboBoxSedeRepuestosInventario;
    private javax.swing.JComboBox<String> comboBoxSedeVehiculosInventario;
    private javax.swing.JComboBox<String> comboBoxTipoVehiculo;
    private javax.swing.JComboBox<String> comboBoxTraccionVehiculo;
    private javax.swing.JPanel construccion;
    private javax.swing.JTextField contrasena_usuario;
    private javax.swing.JTextField cuenta_usuario;
    private javax.swing.JTextField descripcion_repuesto;
    private javax.swing.JTextField dir_sede;
    private javax.swing.JTextField direccion_usuario;
    private javax.swing.JTextField email_usuario;
    private javax.swing.JTextField fax_sede;
    private javax.swing.JTextField id_modificar_respuesto;
    private javax.swing.JTextField id_modificar_vehiculo;
    private javax.swing.JTextField id_sede;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
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
    private javax.swing.JPanel jPanel18;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField marca_vehiculo;
    private javax.swing.JTextField modelo_vehiculo;
    private javax.swing.JTextField nacimiento_usuario;
    private javax.swing.JTextField nombre_repuesto;
    private javax.swing.JTextField nombre_sede;
    private javax.swing.JTextField nombre_usuario;
    private javax.swing.JTextField nuevo_valor_repuesto;
    private javax.swing.JTextField nuevo_valor_usuario;
    private javax.swing.JTextField nuevo_valor_vehiculo;
    private javax.swing.JPanel panelAyudas;
    private javax.swing.JPanel panelConsultarInventario;
    private javax.swing.JPanel panelConsultarSede;
    private javax.swing.JPanel panelConsultarUsuario;
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
    private javax.swing.JPanel panelSedeGerente;
    private javax.swing.JPanel panelUsuariosGerente;
    private javax.swing.JTextField precio_repuesto;
    private javax.swing.JTextField precio_vehiculo;
    private javax.swing.JRadioButton radioBotonCotizacion;
    private javax.swing.JRadioButton radioBotonGeneroF;
    private javax.swing.JRadioButton radioBotonGeneroM;
    private javax.swing.JRadioButton radioBotonOrden;
    private javax.swing.JRadioButton radioBotonRepuesto;
    private javax.swing.JRadioButton radioBotonVehiculo;
    private javax.swing.JRadioButton radioBotonVenta;
    private javax.swing.JTextField referencia_vehiculo;
    private javax.swing.JTextField salario_usuario;
    private javax.swing.JComboBox<String> seleccionarSede;
    private javax.swing.JTextField telefono_sede;
    private javax.swing.JTextField telefono_usuario;
    private javax.swing.JTextField valor_actual_sede;
    private javax.swing.JTextField valor_consulta_inventario;
    private javax.swing.JTextField valor_consulta_sede;
    private javax.swing.JTextField valor_consulta_usuario;
    private javax.swing.JTextField valor_nuevo_sede;
    // End of variables declaration//GEN-END:variables
}
