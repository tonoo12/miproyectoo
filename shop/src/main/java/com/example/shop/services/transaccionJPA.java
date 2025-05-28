@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private RegistroLogRepository logRepository;

    @Transactional
    public void crearProducto(Producto producto) {
        productoRepository.save(producto); // Se guarda el producto

        RegistroLog log = new RegistroLog();
        log.setAccion("Producto creado: " + producto.getNombre());
        log.setFecha(LocalDateTime.now());

        logRepository.save(log); // Se guarda el log

       
    }
}
