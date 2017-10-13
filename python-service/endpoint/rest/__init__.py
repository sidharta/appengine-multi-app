import os
from importlib import import_module

for f in os.listdir("../" + __name__.replace(".", "/")):
    if f.endswith("controller.py"):
        import_module(__name__ + "." + f.replace(".py", ""), "*")

