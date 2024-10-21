package com.ldb.loanapi.controller;

import com.ldb.loanapi.Entities.Location.DistrictEntity;
import com.ldb.loanapi.Entities.Location.VillageEntity;
import com.ldb.loanapi.Exceptions.DetailMessage.ExceptionResponse;
import com.ldb.loanapi.Exceptions.Exception2.BadRequestException;
import com.ldb.loanapi.Exceptions.Exception2.ForbiddenException;
import com.ldb.loanapi.Exceptions.Exception2.NotFoundException;
import com.ldb.loanapi.Exceptions.ExceptionStatus.InternalServerError;
import com.ldb.loanapi.Exceptions.ExceptionStatus.UnAuthorizedException;
import com.ldb.loanapi.Messages.response.DataResponse;
import com.ldb.loanapi.Repositories.UserRepository;
import com.ldb.loanapi.Security.jwt.JwtTokenProvider;
import com.ldb.loanapi.Utils.APIMappingPaths;
import com.ldb.loanapi.services.ProvinceService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.ServiceUnavailableException;
import javax.servlet.http.HttpServletRequest;
@Slf4j
@RestController
@RequestMapping(
        value = {"${url.mapping}" + APIMappingPaths.API_MB_GATEWAY_VERSION_PATH
                + APIMappingPaths.API_MB_REPORT_PATH + APIMappingPaths.API_AUTHENTICATION_GATEWAY_PATH}
)
public class VillageController {

    @Value("${app.jwtExpirationInMs}") // 3  minus
    private int jwtExpirationInMs;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final ProvinceService provinceService;

    public VillageController(UserRepository userRepository, ProvinceService provinceService) {
        this.userRepository = userRepository;
        this.provinceService = provinceService;
    }

    //***************************get all data
    @ApiOperation(
            value = "VillageController in show data",
            authorizations = {@Authorization(value = "apiKey")},
            response = VillageController.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VillageController.class),
            @ApiResponse(code = 201, message = "Created", response = ExceptionResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = BadRequestException.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = UnAuthorizedException.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ForbiddenException.class),
            @ApiResponse(code = 404, message = "Not Found", response = NotFoundException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ServiceUnavailableException.class)
    })
    @RequestMapping(
            value = APIMappingPaths.VILLAGE.API_VILLAGE_VIEW,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResponseEntity<?> getDistrictView(VillageEntity villageEntity, HttpServletRequest request) {
        DataResponse dataResponse = new DataResponse();
        try {
            //  public DataResponse getProvinceList(ProvinceEntity provinceEntity);
            log.info("++ Mobile Login Request Token ..............................");
            log.info("Client IP Address: " + request.getRemoteAddr());
            dataResponse.setDataResponse(provinceService.getVillageList(villageEntity));
            if (dataResponse.getDataResponse() != null) {
                dataResponse.setStatus("00");
                dataResponse.setMessage("Success");
            } else {
                dataResponse.setStatus("05");
                dataResponse.setMessage("Data Not Found");
            }
        } catch (Exception e) {
            log.error("Authentication error = " + e.getMessage());
        }
        return ResponseEntity.ok().body(dataResponse);
    }

    @ApiOperation(
            value = "VillageController in show data",
            authorizations = {@Authorization(value = "apiKey")},
            response = VillageController.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VillageController.class),
            @ApiResponse(code = 201, message = "Created", response = ExceptionResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = BadRequestException.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = UnAuthorizedException.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ForbiddenException.class),
            @ApiResponse(code = 404, message = "Not Found", response = NotFoundException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ServiceUnavailableException.class)
    })
    @RequestMapping(
            value = APIMappingPaths.VILLAGE.API_STORE_VILLAGE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResponseEntity<?> saveVillage(VillageEntity villageEntity, HttpServletRequest request) {
        DataResponse dataResponse = new DataResponse();
        try {
            //  public DataResponse getProvinceList(ProvinceEntity provinceEntity);
            log.info("++ Mobile Login Request Token ..............................");
            log.info("Client IP Address: " + request.getRemoteAddr());
            dataResponse.setDataResponse(provinceService.saveVillage(villageEntity));
            if (dataResponse.getDataResponse() != null) {
                dataResponse.setStatus("00");
                dataResponse.setMessage("Success");
            } else {
                dataResponse.setStatus("05");
                dataResponse.setMessage("Data Not Found");
            }
        } catch (Exception e) {
            log.error("Authentication error = " + e.getMessage());
        }
        return ResponseEntity.ok().body(dataResponse);
    }

    @ApiOperation(
            value = "DistrictController in show data",
            authorizations = {@Authorization(value = "apiKey")},
            response = VillageController.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VillageController.class),
            @ApiResponse(code = 201, message = "Created", response = ExceptionResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = BadRequestException.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = UnAuthorizedException.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ForbiddenException.class),
            @ApiResponse(code = 404, message = "Not Found", response = NotFoundException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ServiceUnavailableException.class)
    })
    @RequestMapping(
            value = APIMappingPaths.VILLAGE.API_UPDATE_VILLAGE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResponseEntity<?> updateVillage(VillageEntity villageEntity, HttpServletRequest request) {
        DataResponse dataResponse = new DataResponse();
        try {
            //  public DataResponse getProvinceList(ProvinceEntity provinceEntity);
            log.info("++ Mobile Login Request Token ..............................");
            log.info("Client IP Address: " + request.getRemoteAddr());
            dataResponse.setDataResponse(provinceService.updateVillage(villageEntity));
            if (dataResponse.getDataResponse() != null) {
                dataResponse.setStatus("00");
                dataResponse.setMessage("Success");
            } else {
                dataResponse.setStatus("05");
                dataResponse.setMessage("Data Not Found");
            }
        } catch (Exception e) {
            log.error("Authentication error = " + e.getMessage());
        }
        return ResponseEntity.ok().body(dataResponse);
    }

    @ApiOperation(
            value = "DistrictController in show data",
            authorizations = {@Authorization(value = "apiKey")},
            response = VillageController.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = VillageController.class),
            @ApiResponse(code = 201, message = "Created", response = ExceptionResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = BadRequestException.class),
            @ApiResponse(code = 401, message = "Unauthorized", response = UnAuthorizedException.class),
            @ApiResponse(code = 403, message = "Forbidden", response = ForbiddenException.class),
            @ApiResponse(code = 404, message = "Not Found", response = NotFoundException.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = InternalServerError.class),
            @ApiResponse(code = 503, message = "Service Unavailable", response = ServiceUnavailableException.class)
    })
    @RequestMapping(
            value = APIMappingPaths.VILLAGE.API_DEL_VILLAGE,
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            },
            method = RequestMethod.POST
    )
    @ResponseBody
    public ResponseEntity<?> delVillage(VillageEntity villageEntity, HttpServletRequest request) {
        DataResponse dataResponse = new DataResponse();
        try {
            //  public DataResponse getProvinceList(ProvinceEntity provinceEntity);
            log.info("++ Mobile Login Request Token ..............................");
            log.info("Client IP Address: " + request.getRemoteAddr());
            dataResponse.setDataResponse(provinceService.delVillage(villageEntity));
            if (dataResponse.getDataResponse() != null) {
                dataResponse.setStatus("00");
                dataResponse.setMessage("Success");
            } else {
                dataResponse.setStatus("05");
                dataResponse.setMessage("Data Not Found");
            }
        } catch (Exception e) {
            log.error("Authentication error = " + e.getMessage());
        }
        return ResponseEntity.ok().body(dataResponse);
    }
}