from flask import Flask, Blueprint
from flask_restplus import Api

from core.usecase.say_hello_usecase import SayHelloUseCase
from gateway.inmemory.real_name_inmemory_gateway import RealNameInMemoryGateway

# The Flask app
app = Flask("python-service")

# Sets the routes
routes = Blueprint('api', __name__)

# Creates the api documentation
api = Api(app, version='1.0', title='Sample API', description='A sample API')
api.init_app(routes)

# Registers the routes within the app
app.register_blueprint(routes)

# Init all the use cases injecting the gateways
say_hello_uc = SayHelloUseCase(RealNameInMemoryGateway())

