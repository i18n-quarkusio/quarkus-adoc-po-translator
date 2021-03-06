/**
* Globalese
* This is the Globalese API v2.1 documentation. More information about Globalese: [globalese.ai](https://www.globalese-mt.com)  **Base URL** ``` https://{subdomain}.globalese.ai/api/v2.1/ ```  The use of the `https` protocol is mandatory.  # Authentication Globalese requires Basic HTTP authentication. Every request **must** contain an `Authorization` header using the username and API key associated with a user account existing in Globalese.  Assuming the username is `john_doe` and the API key is `12345678`, the header entry should look like this: ``` Authorization: Basic am9obl9kb2U6MTIzNDU2Nzg= ``` The actions performed through the API reflect the restrictions by groups and permissions the authenticated user has.  # Checking user credentials Globalese offers the `/` endpoint accepting `GET` requests.  Sending an empty `GET /` request with the appropriate `Authorization` header will either return a `200` or a `401` response.  # Format The necessary parameters must be passed on in the following manner: * `GET` and `DELETE` requests: in the query part of the URL * `POST`, `PUT` and `PATCH` requests: in the request body as a JSON-encoded array * File uploads: in the request body  ## Passing arrays in GET requests If a request parameter is an array, use a comma-separated form of array elements (no spaces) in the `GET` request parameters. For example, if: ``` $group = [1, 3, 7] ``` then in the request, use the query parameters in the form of ``` ?group=1,3,7 ```  ## Language codes Globalese works with the 2-letter [ISO 639-1 codes](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) for languages and the 2-letter [ISO-3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) codes for countries in the following format: ``` en fr zh ``` or ``` en-us fr-fr zh-cn ```  # Responses ## Format All responses containing a body that is not a file use the JSON format.  ## HTTP status codes used The following HTTP status codes are sent back in response headers: ``` 200  The request has been processed. 201  A new resource has been created. 400  Bad request or missing required parameter. 401  Unauthorized request. 403  Insufficient user permissions. 404  Entity not found. 500  Internal error while processing the request. ```  ## Error messages In case the request returns an error, the error message is sent in JSON format as shown here (except for 401 responses which always indicate an authorisation error): ``` {     \"error\": \"Some error message.\" } ``` 
*
* The version of the OpenAPI document: 2.2
* 
*
* NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
* https://openapi-generator.tech
* Do not edit the class manually.
*/
package net.sharplab.translator.generated.api

import net.sharplab.translator.generated.model.CreateTranslationFile
import net.sharplab.translator.generated.model.Error
import net.sharplab.translator.generated.model.InlineResponse2013
import net.sharplab.translator.generated.model.TranslationFile

import org.openapitools.client.infrastructure.ApiClient
import org.openapitools.client.infrastructure.ClientException
import org.openapitools.client.infrastructure.ClientError
import org.openapitools.client.infrastructure.ServerException
import org.openapitools.client.infrastructure.ServerError
import org.openapitools.client.infrastructure.MultiValueMap
import org.openapitools.client.infrastructure.RequestConfig
import org.openapitools.client.infrastructure.RequestMethod
import org.openapitools.client.infrastructure.ResponseType
import org.openapitools.client.infrastructure.Success
import org.openapitools.client.infrastructure.toMultiValue

class TranslationFilesApi(basePath: kotlin.String = defaultBasePath) : ApiClient(basePath) {
    companion object {
        @JvmStatic
        val defaultBasePath: String by lazy {
            System.getProperties().getProperty("org.openapitools.client.baseUrl", "http://localhost")
        }
    }

    /**
    * List translation files
    * Returns a collection of translation files, optionally filtered.
    * @param limit Limit for results. *May* be used together with &#x60;offset&#x60;. Examples: &#x60;25&#x60;, &#x60;50&#x60;  (optional)
    * @param offset Offset to start query from. **Must** be used together with &#x60;limit&#x60;. Examples: &#x60;50&#x60;, &#x60;100&#x60;  (optional)
    * @param source Source language. Examples: &#x60;en&#x60;, &#x60;fr&#x60;  (optional)
    * @param target Target language. Examples: &#x60;en&#x60;, &#x60;fr&#x60;  (optional)
    * @param project Project ID. Examples: &#x60;1&#x60;, &#x60;2&#x60;  (optional)
    * @param groups Group ID(s) for filtering. Examples: &#x60;1&#x60;, &#x60;1,3,5&#x60;  (optional)
    * @param status Translation file status. (optional)
    * @return kotlin.collections.List<TranslationFile>
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesGet(limit: kotlin.Int?, offset: kotlin.Int?, source: kotlin.String?, target: kotlin.String?, project: kotlin.String?, groups: kotlin.collections.List<kotlin.Int>?, status: kotlin.String?) : kotlin.collections.List<TranslationFile> {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                if (limit != null) {
                    put("limit", listOf(limit.toString()))
                }
                if (offset != null) {
                    put("offset", listOf(offset.toString()))
                }
                if (source != null) {
                    put("source", listOf(source.toString()))
                }
                if (target != null) {
                    put("target", listOf(target.toString()))
                }
                if (project != null) {
                    put("project", listOf(project.toString()))
                }
                if (groups != null) {
                    put("groups", toMultiValue(groups.toList(), "multi"))
                }
                if (status != null) {
                    put("status", listOf(status.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/translation-files",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.collections.List<TranslationFile>>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.collections.List<TranslationFile>
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Cancel the translation of a file
    * Translations can only be cancelled if they are still in the queue. 
    * @param id  
    * @return void
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdCancelPost(id: kotlin.String) : Unit {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/translation-files/{id}/cancel".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<Any?>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Delete a translation file
    * 
    * @param id  
    * @return void
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdDelete(id: kotlin.String) : Unit {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.DELETE,
            "/translation-files/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<Any?>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Download a translation file
    * Returns a translation file.
    * @param id  
    * @param state Original or translated state of the file. 
    * @param zip Whether or not to zip the file before downloading.  Defaults to &#39;false&#39;.  (optional, default to false)
    * @return kotlin.String
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdDownloadGet(id: kotlin.String, state: kotlin.String, zip: kotlin.Boolean?) : kotlin.String {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf<kotlin.String, List<kotlin.String>>()
            .apply {
                put("state", listOf(state.toString()))
                if (zip != null) {
                    put("zip", listOf(zip.toString()))
                }
            }
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/translation-files/{id}/download".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<kotlin.String>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as kotlin.String
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Show the details of a translation file
    * Returns a single translation file.
    * @param id  
    * @return TranslationFile
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdGet(id: kotlin.String) : TranslationFile {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.GET,
            "/translation-files/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<TranslationFile>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as TranslationFile
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Upload a translation file
    * This is the second of the required two steps for uploading a new translation file. The first step is &#x60;POST /translation-files&#x60;.  Accepted CAT tool file formats: * &#x60;.mqxliff&#x60;/&#x60;.mqxlz&#x60; from memoQ * &#x60;.mxliff&#x60; from Memsource * &#x60;.sdlxliff&#x60; from SDL Trados Studio * &#x60;.txlf&#x60; from Wordfast * &#x60;.xliff&#x60;/&#x60;.xlf&#x60; from Smartcat, XTM, translate5, Wordbee, SDL (Idiom) WorldServer, or any standard XLIFF 1.2 * &#x60;.xlz&#x60; from SDL (Idiom) WorldServer 
    * @param id  
    * @param body  
    * @return void
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdPost(id: kotlin.String, body: kotlin.String) : Unit {
        val localVariableBody: kotlin.Any? = body
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        localVariableHeaders["Content-Type"] = "text/plain"
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/translation-files/{id}".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<Any?>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Translate a file
    * **Note:** A file can only be translated if the engine assigned for the project is ready for translation, i.e. it has the status &#x60;trained&#x60; or &#x60;changed&#x60;. 
    * @param id  
    * @return void
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesIdTranslatePost(id: kotlin.String) : Unit {
        val localVariableBody: kotlin.Any? = null
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/translation-files/{id}/translate".replace("{"+"id"+"}", "$id"),
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<Any?>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> Unit
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

    /**
    * Create a new translation file entity as a prerequisite before uploading
    * This is the first of the required two steps for uploading a new translation file. The second step is &#x60;POST /translation-files/{id}&#x60; 
    * @param createTranslationFile  
    * @return InlineResponse2013
    * @throws UnsupportedOperationException If the API returns an informational or redirection response
    * @throws ClientException If the API returns a client error response
    * @throws ServerException If the API returns a server error response
    */
    @Suppress("UNCHECKED_CAST")
    @Throws(UnsupportedOperationException::class, ClientException::class, ServerException::class)
    fun translationFilesPost(createTranslationFile: CreateTranslationFile) : InlineResponse2013 {
        val localVariableBody: kotlin.Any? = createTranslationFile
        val localVariableQuery: MultiValueMap = mutableMapOf()
        val localVariableHeaders: MutableMap<String, String> = mutableMapOf()
        val localVariableConfig = RequestConfig(
            RequestMethod.POST,
            "/translation-files",
            query = localVariableQuery,
            headers = localVariableHeaders
        )
        val localVarResponse = request<InlineResponse2013>(
            localVariableConfig,
            localVariableBody
        )

        return when (localVarResponse.responseType) {
            ResponseType.Success -> (localVarResponse as Success<*>).data as InlineResponse2013
            ResponseType.Informational -> throw UnsupportedOperationException("Client does not support Informational responses.")
            ResponseType.Redirection -> throw UnsupportedOperationException("Client does not support Redirection responses.")
            ResponseType.ClientError -> {
                val localVarError = localVarResponse as ClientError<*>
                throw ClientException("Client error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
            ResponseType.ServerError -> {
                val localVarError = localVarResponse as ServerError<*>
                throw ServerException("Server error : ${localVarError.statusCode} ${localVarError.message.orEmpty()}", localVarError.statusCode, localVarResponse)
            }
        }
    }

}
