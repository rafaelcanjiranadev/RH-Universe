package Services;

import Model.LoginModel;

public class Permissoes {

    public static boolean btnCadastrar(LoginModel usuario) {
        return usuario.getTipo_User() == LoginModel.Tipo_User.ADM
            || usuario.getTipo_User() == LoginModel.Tipo_User.GERENTE;
    }

    public static boolean btnEditar(LoginModel usuario) {
        return usuario.getTipo_User() == LoginModel.Tipo_User.ADM
            || usuario.getTipo_User() == LoginModel.Tipo_User.GERENTE;
    }

    public static boolean btnExcluir(LoginModel usuario) {
        return usuario.getTipo_User() == LoginModel.Tipo_User.GERENTE;
    }

    public static boolean btnFolha(LoginModel usuario) {
        return usuario.getTipo_User() == LoginModel.Tipo_User.ADM
            || usuario.getTipo_User() == LoginModel.Tipo_User.GERENTE;
    }
}
