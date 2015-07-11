package ventas;

public class Ventas {
    private String NroFactura;
    private String Vendedor;
    private String Cliente;
    private String Nombre_Producto;
    private String Valor;
    private String SubTotal;
    private String Iva;
    private String Total;
    
    
   
    
    public Ventas (String NroFactura, String Vendedor, String Cliente, String Nombre_Producto, 
            String Valor, String SubTotal, String Iva, String Total ){
        this.NroFactura = NroFactura;
        this.Vendedor = Vendedor;
        this.Cliente = Cliente;
        this.Nombre_Producto = Nombre_Producto ;
        this.Valor = Valor;
        this.SubTotal = SubTotal;
        this.Iva = Iva;
        this.Total = Total ;
        
    }

    public String getNroFactura() {
        return NroFactura;
    }

    public void setNroFactura(String NroFactura) {
        this.NroFactura = NroFactura;
    }

    public String getVendedor() {
        return Vendedor;
    }

    public void setVendedor(String Vendedor) {
        this.Vendedor = Vendedor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getNombre_Producto() {
        return Nombre_Producto;
    }

    public void setNombre_Producto(String Nombre_Producto) {
        this.Nombre_Producto = Nombre_Producto;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(String SubTotal) {
        this.SubTotal = SubTotal;
    }

    public String getIva() {
        return Iva;
    }

    public void setIva(String Iva) {
        this.Iva = Iva;
    }

    public String getTotal() {
        return Total;
    }

    public void setTotal(String Total) {
        this.Total = Total;
    }

   
    
    public String toString(){
        return NroFactura + " " +Vendedor + " " + Cliente + " " + Nombre_Producto + " " + Valor +
                " " + SubTotal + " " + Iva + " " + Total + " " ;
    }
}

