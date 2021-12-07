import pymysql
class Conexion:

    def __init__(self,usuario,passw,bd):
        self._usuario = usuario
        self._passw = passw
        self._bd = bd
        try:
            self._conexion = pymysql.connect(host='localhost',user = self._usuario,password = self._passw, db = self._bd)
            self._conexion.close()
            print("Datos de conexion correctos.")
        except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
            print("Ocurrió un error con los datos de conexión: ", e)

    def conectar(self):
        """Devuelve la variable conexion o -1 si la conexion ha fallado"""
        try:
            self._conexion = pymysql.connect(host='localhost',
                                    user=self._usuario,
                                    password=self._passw,
                                    db=self._bd)
        except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
            return -1
        
    def cerrarConexion(self):
        self._conexion.close()

    def insertarUsuario(self,login,nombre,passwd):
        """Insertamos un usuario en la tabla usuarios"""
        try:
            self.conectar()
            cursor = self._conexion.cursor()
            consulta = "INSERT INTO usuario(login, nombre, pwd) VALUES (%s, %s, %s, %s)"
            cursor.execute(consulta, (login, nombre, passwd))
            self._conexion.commit()
            self.cerrarConexion()
            return 0
        except (pymysql.err.IntegrityError) as e:
            # print("Ocurrió un error al insertar: clave duplicada.", e)
            return -1
    
    
    #https://stackoverflow.com/questions/3286525/return-sql-table-as-json-in-python
    def seleccionarTodos(self):
        try:
            self.conectar()
            with self._conexion.cursor() as cursor:
                # En este caso no necesitamos limpiar ningún dato
                cursor.execute("SELECT * from usuario")
                r = [dict((cursor.description[i][0], value) for i, value in enumerate(row)) for row in cursor.fetchall()]
                #print(r)
                self.cerrarConexion()
                return r
        except (pymysql.err.OperationalError, pymysql.err.InternalError) as e:
            return []