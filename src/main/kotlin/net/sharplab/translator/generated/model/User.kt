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
package net.sharplab.translator.generated.model


import com.squareup.moshi.Json

/**
 * 
 * @param id 
 * @param active 
 * @param email 
 * @param groups 
 * @param name 
 * @param username 
 */

data class User (
    @Json(name = "id")
    val id: kotlin.Int,
    @Json(name = "active")
    val active: kotlin.Boolean,
    @Json(name = "email")
    val email: kotlin.String,
    @Json(name = "groups")
    val groups: kotlin.collections.List<kotlin.Int>,
    @Json(name = "name")
    val name: kotlin.String,
    @Json(name = "username")
    val username: kotlin.String
)

