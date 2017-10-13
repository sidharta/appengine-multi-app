from app import app
from importlib import import_module

if __name__ == '__main__':
    import_module("endpoint.rest")
    app.run()
