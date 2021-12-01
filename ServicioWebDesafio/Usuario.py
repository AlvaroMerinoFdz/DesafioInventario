import json

class UsuarioEncoder(json.JSONEncoder):
    def default(self,obj):
        return obj.__dict__

class Usuario(object):
    def __init__(self, login, pwd, rol) -> None:
        self.Login = login
        self.Pwd = pwd
        self.Rol = rol

    def __str__(self):
        return json.dumps(self)
