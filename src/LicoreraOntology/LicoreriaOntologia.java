/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LicoreraOntology;


import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.ReflectiveIntrospector;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ConceptSchema;
import jade.content.schema.ObjectSchema;
import jade.content.schema.PredicateSchema;
import jade.content.schema.TermSchema;

/**
 *
 * @author josec
 */
public class LicoreriaOntologia extends jade.content.onto.Ontology{
    public static final String ONTOLOGY_NAME = "licoreria";
  // The singleton instance of this ontology
  private static ReflectiveIntrospector introspect = new ReflectiveIntrospector();
  private static Ontology theInstance = new LicoreriaOntologia();
  public static Ontology getInstance() {
     return theInstance;
  }
  // VOCABULARY
    public static final String NODISPONIBLE="NoDisponible";
    public static final String DISPONIBLE="Disponible";
    public static final String DISPONIBLE_TIEMPO="TIEMPO";
    public static final String NODISPONIBLE_MOTIVO="MOTIVO";
    public static final String FORMADEPAGOENEFECTIVO="FormaDePagoEnEfectivo";
    public static final String FORMADEPAGOCONTARJETA="FormaDePagoConTarjeta";
    public static final String PRODUCTOVENDIDO="ProductoVendido";
    public static final String VENTACONTARJETA="VentaConTarjeta";
    public static final String VENTACONTARJETA_TARJETA="vcttarjeta";
    public static final String VENTACONTARJETA_LICOR="vctlicor";
    public static final String VENTAENEFECTIVO="VentaEnEfectivo";
    public static final String VENTAENEFECTIVO_EFECTIVO="veeefectivo";
    public static final String VENTAENEFECTIVO_LICOR="ceelicor";
    public static final String TARJETA_NTARJETA="ntarjeta";
    public static final String TARJETA_MONTO="mtarjeta";
    public static final String TARJETA_CLIENTE="ctarjeta";
    public static final String EFECTIVO_MONTO="emonto";
    public static final String CLIENTE_NOMBRE="ncliente";
    public static final String CLIENTE_CEDULA="ccliente";
    public static final String CLIENTE_EDAD="ecliente";
    public static final String PRODUCTOVENDIDO_LICOR="pvlicor";
    public static final String FDPAGOEFECTIVO_EFECTIVO="fdpeefectivo";
    public static final String FDPAGOTARJETA_TARJETA="fdpttarjeta";
    public static final String TARJETA="Tarjeta";
    public static final String DESCRIPCION_NOMBRE="nombre";
    public static final String DESCRIPCION_PRECIO="precio";
    public static final String DESCRIPCION_ORIGEN="origen";
    public static final String DESCRIPCION_VOLUMEN="volumen";
    public static final String DESCRIPCION="Descripcion";
    public static final String MOTIVO_MOTIVO="motivo";
    public static final String MOTIVO_CLIENTE="mcliente";
    public static final String MOTIVO="Motivo";
    public static final String LICOR_DESCRIPCION="descripcion";
    public static final String LICOR="Licor";
    public static final String EFECTIVO="Efectivo";
    public static final String CLIENTE="Cliente";
    public static final String TIEMPOVENTA="TiempoVenta";
    public static final String TIEMPOVENTA_TIEMPO="Tiempo";
    
    
 
  /**
   * Constructor
  */
  private LicoreriaOntologia(){
    super(ONTOLOGY_NAME, BasicOntology.getInstance());
    try {
 
    // adding Concept(s)
    ConceptSchema licorSchema = new ConceptSchema(LICOR);
    add(licorSchema, Licor.class);
    ConceptSchema motivoSchema = new ConceptSchema(MOTIVO);
    add(motivoSchema, Motivo.class);
    ConceptSchema descripcionSchema = new ConceptSchema(DESCRIPCION);
    add(descripcionSchema, Descripcion.class);
    ConceptSchema tarjetaSchema = new ConceptSchema(TARJETA);
    add(tarjetaSchema, Tarjeta.class);
    ConceptSchema efectivoSchema = new ConceptSchema(EFECTIVO);
    add(efectivoSchema, Tarjeta.class);
    ConceptSchema clienteSchema = new ConceptSchema(CLIENTE);
    add(clienteSchema, Tarjeta.class);
    ConceptSchema tiempoVentaSchema = new ConceptSchema(TIEMPOVENTA);
    add(tiempoVentaSchema, TiempoVenta.class);
    
    
 
    // adding AgentAction(s)
    AgentActionSchema ventaconTarjetaSchema = new AgentActionSchema(VENTACONTARJETA);
    add(ventaconTarjetaSchema, VentaConTarjeta.class);
    AgentActionSchema ventaenEfectivoSchema = new AgentActionSchema(VENTAENEFECTIVO);
    add(ventaenEfectivoSchema, VentaEnEfectivo.class);
 
    // adding AID(s)
 
    // adding Predicate(s)
        PredicateSchema productoVendidoSchema = new PredicateSchema(PRODUCTOVENDIDO);
    add(productoVendidoSchema, ProductoVendido.class);
    PredicateSchema formadePagoenEfectivoSchema = new PredicateSchema(FORMADEPAGOENEFECTIVO);
    add(formadePagoenEfectivoSchema, Formadepagoefectivo.class);
    PredicateSchema formadePagoconTarjetaSchema = new PredicateSchema(FORMADEPAGOCONTARJETA);
    add(formadePagoconTarjetaSchema, FormadePagoTarjeta.class);
    PredicateSchema noDisponibleSchema = new PredicateSchema(NODISPONIBLE);
    add(noDisponibleSchema, NoDisponible.class);
    PredicateSchema DisponibleSchema = new PredicateSchema(DISPONIBLE);
    add(DisponibleSchema, Disponible.class);
 
    // adding fields
    licorSchema.add(LICOR_DESCRIPCION, descripcionSchema, ObjectSchema.OPTIONAL);
    motivoSchema.add(MOTIVO_MOTIVO, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    motivoSchema.add(MOTIVO_CLIENTE, clienteSchema, ObjectSchema.OPTIONAL);
    descripcionSchema.add(DESCRIPCION_NOMBRE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    descripcionSchema.add(DESCRIPCION_PRECIO, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    descripcionSchema.add(DESCRIPCION_ORIGEN, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    descripcionSchema.add(DESCRIPCION_VOLUMEN, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    tarjetaSchema.add(TARJETA_NTARJETA, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    tarjetaSchema.add(TARJETA_MONTO, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    tarjetaSchema.add(TARJETA_CLIENTE, clienteSchema, ObjectSchema.OPTIONAL);
    efectivoSchema.add(EFECTIVO_MONTO, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_NOMBRE, (TermSchema)getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_CEDULA, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    clienteSchema.add(CLIENTE_EDAD, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    productoVendidoSchema.add(PRODUCTOVENDIDO_LICOR, licorSchema, ObjectSchema.OPTIONAL);
    formadePagoenEfectivoSchema.add(FDPAGOEFECTIVO_EFECTIVO, efectivoSchema, ObjectSchema.OPTIONAL);
    noDisponibleSchema.add(NODISPONIBLE_MOTIVO, motivoSchema, ObjectSchema.OPTIONAL);
    formadePagoconTarjetaSchema.add(FDPAGOTARJETA_TARJETA, tarjetaSchema, ObjectSchema.OPTIONAL);
    ventaconTarjetaSchema.add(VENTACONTARJETA_TARJETA, tarjetaSchema, ObjectSchema.OPTIONAL);
    ventaconTarjetaSchema.add(VENTACONTARJETA_LICOR, licorSchema, ObjectSchema.OPTIONAL);
    ventaenEfectivoSchema.add(VENTAENEFECTIVO_EFECTIVO, efectivoSchema, ObjectSchema.OPTIONAL);
    ventaenEfectivoSchema.add(VENTAENEFECTIVO_LICOR, licorSchema, ObjectSchema.OPTIONAL);
    tiempoVentaSchema.add(TIEMPOVENTA_TIEMPO, (TermSchema)getSchema(BasicOntology.INTEGER), ObjectSchema.OPTIONAL);
    DisponibleSchema.add(DISPONIBLE_TIEMPO, tiempoVentaSchema, ObjectSchema.OPTIONAL);
    
    // adding name mappings
 
    // adding inheritance
 
   }catch (java.lang.Exception e) {e.printStackTrace();}
  }
  }