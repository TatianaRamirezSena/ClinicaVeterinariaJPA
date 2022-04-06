package controlador;

import com.tatiana.dao.MascotaDao;
import com.tatiana.dao.ProductoDao;
import com.tatiana.gui.ActualizarMascotasGui;
import com.tatiana.gui.ActualizarPersonaGui;
import com.tatiana.gui.ActualizarProductos;
import com.tatiana.gui.ComprarProductos;
import com.tatiana.gui.ConsultarMascotasGui;
import com.tatiana.gui.ConsultarPersonaGui;
import com.tatiana.gui.ConsultarProductos;
import com.tatiana.gui.EliminarMascotasGui;
import com.tatiana.gui.EliminarPersonaGui;
import com.tatiana.gui.EliminarProductos;
import com.tatiana.gui.ListarMascotasGui;
import com.tatiana.gui.ListarPersonasGui;
import com.tatiana.gui.ListarProductos;
import com.tatiana.gui.RegistrarMascotasGui;
import com.tatiana.gui.RegistrarPersonasGui;
import com.tatiana.gui.RegistrarProductos;
import com.tatiana.gui.VentanaPrincipal;

public class Relaciones {

	public Relaciones() {
		
		Coordinador miCoordinador;
		VentanaPrincipal miVentanaPrincipal;
		ProductoDao miProductoDao;
		MascotaDao miAnimalDao;
		RegistrarProductos miRegistrarProductos;
		ConsultarProductos miConsultarProductos;
		ListarProductos miListarProductos;
		EliminarProductos miEliminarProductos;
		ActualizarProductos miActualizarProductos;
		ComprarProductos miComprarProducto;
		RegistrarPersonasGui miRegistrarPersonasGui;
		ListarPersonasGui miListarPersonasGui;
		ActualizarPersonaGui miActualizarPersonasGui;
		EliminarPersonaGui miEliminarPersonaGui;
		ConsultarPersonaGui miConsultarPersonaGui;
		RegistrarMascotasGui miRegistrarMascotasGui;
		ConsultarMascotasGui miConsultarMascotasGui;
		ActualizarMascotasGui miActualizarMascotasGui;
		ListarMascotasGui miListarMascotasGui;
		EliminarMascotasGui miEliminarMascotasGui;

		miVentanaPrincipal= new VentanaPrincipal();
		miRegistrarProductos= new RegistrarProductos(miVentanaPrincipal, true);
		miConsultarProductos=new ConsultarProductos(miVentanaPrincipal,true);
		miListarProductos=new ListarProductos(miVentanaPrincipal,true);
		miEliminarProductos=new EliminarProductos(miVentanaPrincipal,true);
		miActualizarProductos=new ActualizarProductos(miVentanaPrincipal,true);
		miRegistrarPersonasGui= new RegistrarPersonasGui(miVentanaPrincipal, true);
		miListarPersonasGui= new ListarPersonasGui();
		miActualizarPersonasGui = new ActualizarPersonaGui(miVentanaPrincipal,true);
		miConsultarPersonaGui=new ConsultarPersonaGui(miVentanaPrincipal, true);
		miEliminarPersonaGui=new EliminarPersonaGui (miVentanaPrincipal,true);
		miRegistrarMascotasGui = new RegistrarMascotasGui(miVentanaPrincipal,true);
		miConsultarMascotasGui = new ConsultarMascotasGui(miVentanaPrincipal, true);
		miActualizarMascotasGui = new ActualizarMascotasGui(miVentanaPrincipal, true);
		miListarMascotasGui = new ListarMascotasGui();
		miEliminarMascotasGui = new EliminarMascotasGui(miVentanaPrincipal, true);
		miComprarProducto = new ComprarProductos(miVentanaPrincipal,true);
		
		miCoordinador= new Coordinador();
		miProductoDao= new ProductoDao();
		miAnimalDao= new MascotaDao();
		
		miCoordinador.setVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setRegistrarProductos(miRegistrarProductos);
		miCoordinador.setConsultarProductos(miConsultarProductos);
		miCoordinador.setListarProductos(miListarProductos);
		miCoordinador.setEliminarProductos(miEliminarProductos);
		miCoordinador.setActualizarProductos(miActualizarProductos);
		miCoordinador.setRegistrarPersonasGui(miRegistrarPersonasGui);
		miCoordinador.setListarPersonasGui(miListarPersonasGui);
		miCoordinador.setActualizarPersonaGui(miActualizarPersonasGui);
		miCoordinador.setConsultarPersonaGUI(miConsultarPersonaGui);
		miCoordinador.setEliminarPersona(miEliminarPersonaGui);
		miCoordinador.setRegistrarMascotasGui(miRegistrarMascotasGui);
		miCoordinador.setActualizarMascotasGui(miActualizarMascotasGui);
		miCoordinador.setConsultarMascotasGui(miConsultarMascotasGui);
		miCoordinador.setListarMascotasGui(miListarMascotasGui);
		miCoordinador.setEliminarMascotasGui(miEliminarMascotasGui);
		miCoordinador.setComprarProductos(miComprarProducto);
		miCoordinador.setProductoDao(miProductoDao);
		miCoordinador.setMascotaDao(miAnimalDao);
		
		miVentanaPrincipal.setCoordinador(miCoordinador);
		miRegistrarProductos.setCoordinador(miCoordinador);
		miConsultarProductos.setCoordinador(miCoordinador);
		miListarProductos.setCoordinador(miCoordinador);
		miEliminarProductos.setCoordinador(miCoordinador);
		miActualizarProductos.setCoordinador(miCoordinador);
		miComprarProducto.setCoordinador(miCoordinador);
		miProductoDao.setCoordinador(miCoordinador);
		miAnimalDao.setCoordinador(miCoordinador);
		miRegistrarPersonasGui.setCoordinador(miCoordinador);
		miListarPersonasGui.setCoordinador(miCoordinador);
		miActualizarPersonasGui.setCoordinador(miCoordinador);
		miConsultarPersonaGui.setCoordinador(miCoordinador);
		miEliminarPersonaGui.setCoordinador(miCoordinador);
		miRegistrarMascotasGui.setCoordinador(miCoordinador);
		miConsultarMascotasGui.setCoordinador(miCoordinador);
		miActualizarMascotasGui.setCoordinador(miCoordinador);
		miListarMascotasGui.setCoordinador(miCoordinador);
		miEliminarMascotasGui.setCoordinador(miCoordinador);
		
		
		
		miVentanaPrincipal.setVisible(true);
	}
	
}
