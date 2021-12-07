import json

class UsuarioEncoder(json.JSONEncoder):
    def default(self,obj):
        return obj.__dict__

class Usuario(object):
    def __init__(self, login,nombre, pwd) -> None:
        self.Login = login
        self.Nombre = nombre
        self.Pwd = pwd
        

    def __str__(self):
        return json.dumps(self)
