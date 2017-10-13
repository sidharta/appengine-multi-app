from flask_restplus import Resource

from app.util import to_dict
from app import api, say_hello_uc


@api.route('/hello/<name>')
@api.doc(params={'name': 'Name for hello'})
class MyResource(Resource):
    def get(self, name):
        return to_dict(say_hello_uc.say_hello(name))
