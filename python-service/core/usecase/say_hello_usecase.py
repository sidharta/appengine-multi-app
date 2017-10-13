from core.domain.hello_message import HelloMessage


class SayHelloUseCase:

    def __init__(self, real_name_gw):
        self._real_name_gw = real_name_gw

    def say_hello(self, name):
        return HelloMessage(msg=self._real_name_gw.get_real_name(name))
