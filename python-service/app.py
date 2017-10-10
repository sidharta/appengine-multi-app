from flask import Flask, Blueprint
from flask_restplus import Api, Resource

app = Flask(__name__)
api = Api(app, version='1.0', title='Sample API', description='A sample API')


def initialize_app(flask_app):
    flask_app.config['SERVER_NAME'] = 'localhost:5000'
    blueprint = Blueprint('api', __name__, url_prefix='/')
    api.init_app(blueprint)
    flask_app.register_blueprint(blueprint)


@api.route('/hello/<name>')
@api.doc(params={'name': 'Name for hello'})
class MyResource(Resource):
    def get(self, name):
        return {"msg": "Python Hello " + name}


if __name__ == '__main__':
    initialize_app(app)
    app.run(debug=True)
