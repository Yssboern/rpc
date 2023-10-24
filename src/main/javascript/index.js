const grpc = require("@grpc/grpc-js");
const protoLoader = require("@grpc/proto-loader");

const PROTO_PATH = "../proto/ping.proto";
const packageDefinition = protoLoader.loadSync(PROTO_PATH, {
    keepCase: true,
    longs: String,
    enums: String,
    defaults: true,
    oneofs: true,
});

const rpcProto = grpc.loadPackageDefinition(packageDefinition);

function sendPing() {
    const client = new rpcProto.com.example.rpc.services.PingService("localhost:50051", grpc.credentials.createInsecure());

    client.getPing({ message: "Ping! [js client]" }, (error, response) => {
        if (error) {
            console.error("Error: ", error);
        } else {
            console.log("JS client Received response:", response.message);
        }
    });
}

sendPing();