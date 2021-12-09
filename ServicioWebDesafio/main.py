from contextlib import nullcontext
from conexionOO import Conexion
from flask import Flask,request,jsonify
from flask_restful import Resource, Api

conex = Conexion('root','','inventario')
app = Flask(__name__)
api = Api(app)


@app.route('/')
def hello():
    return 'Bienvenido a la API de Alvaro Merino, realizada para el Desafío Inventario'

@app.route("/usuarios", methods=['GET']) #aquí especificamos la ruta para el endpoint.
def getPersonas(): #aquí declaramos una función que se llamará cuando se realice una request a esa url
    listaUsuarios = conex.seleccionarTodos()
    if (len(listaUsuarios) != 0):
        resp = jsonify(listaUsuarios)
        resp.status_code = 200
    else:
        respuesta = {'message': 'No se han extraido datos.'}
        resp = jsonify(respuesta)
        resp.status_code = 400
    return resp

@app.route("/usuarios/${id}",methods=['GET'])
def getPersona(id):
    listaPersona = conex.seleccionarUsuario(id)
    if(listaPersona!=0):
        resp = jsonify(listaPersona)
        resp.status_code = 200
    else:
        respuesta = {'message': 'No se han extraido datos.'}
        resp = jsonify(respuesta)
        resp.status_code = 400    
    return resp

if __name__ == '__main__':
     #app.run(debug=True)
    app.run(debug=True, host= '0.0.0.0') #Esto sería para poder usar el móvil. No arrancaría el servicio en localhost sino en esa ip. También 0.0.0.0

# Esto es para montarlo en https.
# if __name__ == "__main__":
#     app.run(ssl_context='adhoc')
