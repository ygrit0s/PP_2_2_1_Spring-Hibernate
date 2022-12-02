package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class UserServiceImp implements UserService {

    public static final Logger LOGGER = Logger.getLogger(UserServiceImp.class.getName());

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listUsers() {
        var result = userDao.listUsers();
        result.forEach(user -> LOGGER.info(user.toString() + "->"
                + user.getCar().toString().indent(8)));
        return result;
    }

    @Transactional(readOnly = true)
    @Override
    public User userByCar(String model, int series) {
        var result = userDao.userByCar(model, series);
        LOGGER.log(Level.INFO, "\nВладелец машины {0} серии {1}: {2}",
                new Object[]{model, series, result});
        return result;
    }
}
