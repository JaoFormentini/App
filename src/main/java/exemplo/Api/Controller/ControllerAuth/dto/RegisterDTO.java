package exemplo.Api.Controller.ControllerAuth.dto;

import exemplo.Api.model.modelUser.UserRole;

public record RegisterDTO (String login, String password, UserRole role){

}
