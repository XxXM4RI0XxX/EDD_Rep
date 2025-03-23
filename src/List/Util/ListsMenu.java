package List.Util;

import java.util.HashMap;

public class ListsMenu {

    HashMap<Integer, Menu> menus = new HashMap<>();

    public static void execute(int op){

    }

    public void setMenus(){
        menus.put(1,()->{//Menu principal
            System.out.println("""
                    1) Usar lista
                    2) Editar lista
                    3) Exportar lista
                    0) Salir
                    """);
        });
        menus.put(2,()->{//Editar listas
            System.out.println("""
                    1) Crear lista
                    2) Editar lista
                    3) Eliminar lista
                    4) Ver listas
                    0) Salir
                    """);
        });
        menus.put(3, () ->{//Crear lista
            System.out.println("");
        });
        menus.put(4,() ->{//Edicion de lista
            System.out.println("""
                    1) Agregar elemento
                    2) Eliminar elemento
                    3) Acomodar lista
                    4) Ver elementos
                    0) Guardar cambios
                    """);
        });

        menus.put(5,() ->{
            System.out.println("""
                    Elija donde agregar el valor:
                    1) Delante
                    2) Detras
                    3) Enmedio
                    4) Aleatorio
                    0) Cancelar
                    """);
        });

    }
}
