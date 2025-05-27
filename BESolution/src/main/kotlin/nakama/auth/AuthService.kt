package org.david.nakama.auth

import io.grpc.stub.StreamObserver
import org.david.grpc.*
import org.david.nakama.NakamaClient

class AuthService: authServiceGrpc.authServiceImplBase() {
    override fun authenticateByDevice(
        request: AuthenticateByDeviceRequest?,
        responseObserver: StreamObserver<AuthenticateByDeviceResponse>?
    ) {
        responseObserver?.onNext(processAuthenticateByDevice(request!!))
        responseObserver?.onCompleted()
    }

    override fun authenticateByEmail(
        request: AuthenticateByEmailRequest?,
        responseObserver: StreamObserver<AuthenticateByEmailResponse>?
    ) {
        responseObserver?.onNext(processAuthenticateByEmail(request!!))
        responseObserver?.onCompleted()
    }

    private fun processAuthenticateByEmail(request: AuthenticateByEmailRequest): AuthenticateByEmailResponse {
        val authToken = NakamaClient.getNakamaClient().authenticateEmail(request.email, request.password).get()

        return AuthenticateByEmailResponse.newBuilder().setAuthToken(authToken.authToken).build()
    }

    private fun processAuthenticateByDevice(request: AuthenticateByDeviceRequest): AuthenticateByDeviceResponse {
        val authToken = NakamaClient.getNakamaClient().authenticateDevice(request.deviceId).get()

        return AuthenticateByDeviceResponse.newBuilder().setAuthToken(authToken.authToken).build()
    }
}