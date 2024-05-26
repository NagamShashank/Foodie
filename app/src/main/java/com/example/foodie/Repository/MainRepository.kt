package com.example.foodie.Repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.foodie.ApiService.MainApiService
import com.example.foodie.AppConstants
import com.example.foodie.MyOrdersScreen.MyOrderModel
import com.example.foodie.RestaurantResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.SSLSession
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import kotlin.collections.ArrayList

class MainRepository {
    private val api: MainApiService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(getUnsafeOkHttpClient().build())
            .build()

        api = retrofit.create(MainApiService::class.java)
    }

    suspend fun getRestaurants(): ArrayList<RestaurantResponse> {
        val response = api.getRestaurants()
        return response.Data ?: ArrayList()
    }

    suspend fun getMyOrders(): ArrayList<MyOrderModel>{
        val orderResponse = api.getMyOrders()
        return orderResponse.Data ?: ArrayList()
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun getUnsafeOkHttpClient(): OkHttpClient.Builder {
        try {
            // Create a trust manager that does not validate certificate chains
            val trustAllCerts: Array<TrustManager> = arrayOf(
                object : X509TrustManager {
                    @Throws(CertificateException::class)
                    override fun checkClientTrusted(
                        chain: Array<java.security.cert.X509Certificate>,
                        authType: String
                    ) {
                    }

                    @Throws(CertificateException::class)
                    override fun checkServerTrusted(
                        chain: Array<java.security.cert.X509Certificate>,
                        authType: String
                    ) {
                    }

                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                        return arrayOf()
                    }
                }
            )

            // Install the all-trusting trust manager
            val sslContext: SSLContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            // Create an ssl socket factory with our all-trusting manager
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier(HostnameVerifier { hostname: String?, session: SSLSession? -> true })
            return builder
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }
}