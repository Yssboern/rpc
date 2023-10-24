import grpc
import ping_pb2
import ping_pb2_grpc

def run():
    channel = grpc.insecure_channel('localhost:50051')
    stub = ping_pb2_grpc.PingServiceStub(channel)

    request = ping_pb2.PingRequest(message='Ping! [python client]')

    response = stub.getPing(request)
    print("Received response:", response.message)

if __name__ == '__main__':
    run()