package kr.ac.dongseo.reservation.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.dongseo.reservation.dao.CategoryDao;
import kr.ac.dongseo.reservation.dao.DisplayInfoImageDao;
import kr.ac.dongseo.reservation.dao.ProductDao;
import kr.ac.dongseo.reservation.dao.ProductImageDao;
import kr.ac.dongseo.reservation.dao.ProductPriceDao;
import kr.ac.dongseo.reservation.dao.PromotionDao;
import kr.ac.dongseo.reservation.dao.ReservationInfoDao;
import kr.ac.dongseo.reservation.dao.ReservationInfoPriceDao;
import kr.ac.dongseo.reservation.dao.ReservationUserCommentDao;
import kr.ac.dongseo.reservation.dto.Category;
import kr.ac.dongseo.reservation.dto.DisplayInfoImage;
import kr.ac.dongseo.reservation.dto.Product;
import kr.ac.dongseo.reservation.dto.ProductImage;
import kr.ac.dongseo.reservation.dto.ProductPrice;
import kr.ac.dongseo.reservation.dto.Promotion;
import kr.ac.dongseo.reservation.dto.ReservationInfo;
import kr.ac.dongseo.reservation.dto.ReservationInfoPrice;
import kr.ac.dongseo.reservation.dto.ReservationUserComment;
import kr.ac.dongseo.reservation.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    DisplayInfoImageDao displayInfoImageDao;

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductImageDao productImageDao;

    @Autowired
    ProductPriceDao productPriceDao;

    @Autowired
    PromotionDao promotionDao;

    @Autowired
    ReservationUserCommentDao reservationUserCommentDao;

    @Autowired
    ReservationInfoDao reservationInfoDao;

    @Autowired
    ReservationInfoPriceDao reservationInfoPriceDao;

    private static final String SUCCESS_MESSAGE = "success";
    private static final String FAIL_MESSAGE = "fail";

    @Override
    @Transactional
    public Map<String, Object> getCategories() {
        Map<String, Object> resultMap = new HashMap<>();

        List<Category> items = categoryDao.selectAll();
        Integer size = items.size();

        resultMap.put("size", size);
        resultMap.put("items", items);

        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> getProducts(Map<String, Integer> params) {
        Map<String, Object> resultMap = new HashMap<>();

        Integer categoryId = params.get("categoryId");
        Integer start = params.get("start");

        Long totalCount;
        Integer productCount;
        List<Product> products;

        Boolean categoryIdIsNull = (categoryId == null);

        if (!categoryIdIsNull && start != null) {
            if (categoryId != 0) {
                products = productDao.selectPage(categoryId, start, DISPLAYINFOS_LIMIT);
                totalCount = productDao.selectTotalCount(categoryId);
            } else {
                products = productDao.selectAll(start, DISPLAYINFOS_LIMIT);
                totalCount = productDao.selectTotalCount();
            }

        } else if (!categoryIdIsNull && start == null) {
            if (categoryId != 0) {
                products = productDao.selectPage(categoryId, BASIC_START, DISPLAYINFOS_LIMIT);
                totalCount = productDao.selectTotalCount(categoryId);
            } else {
                products = productDao.selectAll(BASIC_START, DISPLAYINFOS_LIMIT);
                totalCount = productDao.selectTotalCount();
            }

        } else if (categoryIdIsNull && start != null) {
            products = productDao.selectAll(start, DISPLAYINFOS_LIMIT);
            totalCount = productDao.selectTotalCount();

        } else {
            products = productDao.selectAll(BASIC_START, DISPLAYINFOS_LIMIT);
            totalCount = productDao.selectTotalCount();
        }
        productCount = products.size();

        resultMap.put("totalCount", totalCount);
        resultMap.put("productCount", productCount);
        resultMap.put("products", products);

        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> getPromotions() {
        Map<String, Object> resultMap = new HashMap<>();

        List<Promotion> items = promotionDao.selectAll();
        Integer size = items.size();

        resultMap.put("size", size);
        resultMap.put("items", items);

        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> getDisplayinfos(Map<String, Integer> params) {
        Map<String, Object> resultMap = new HashMap<>();

        Integer displayId = params.get("displayId");

        Product product;
        List<ProductImage> productImages;
        List<DisplayInfoImage> displayInfoImages;
        Integer avgScore;
        List<ProductPrice> productPrices;

        if (displayId != null) {
            product = productDao.select(displayId);
            productImages = productImageDao.select(displayId);
            displayInfoImages = displayInfoImageDao.select(displayId);
            avgScore = getAvgScore(reservationUserCommentDao.selectScore(displayId));
            productPrices = productPriceDao.selectAllByProductId(displayId);

            resultMap.put("product", product);
            resultMap.put("productImages", productImages);
            resultMap.put("displayInfoImages", displayInfoImages);
            resultMap.put("avgScore", avgScore);
            resultMap.put("productPrices", productPrices);
        }

        return resultMap;
    }

    @Override
    @Transactional
    public Map<String, Object> getReservationUserComments(Map<String, Integer> params) {
        Map<String, Object> resultMap = new HashMap<>();

        Integer productId = params.get("productId");
        Integer start = params.get("start");

        Long totalCount;
        Integer commentCount;
        List<ReservationUserComment> reservationUserComments;

        if (productId != null && start != null) {
            reservationUserComments = reservationUserCommentDao.selectByProductId(productId, start,
                    RESERVATION_USER_COMMENT_LIMIT);
            totalCount = reservationUserCommentDao.selectTotalCount(productId);

        } else if (productId != null && start == null) {
            reservationUserComments = reservationUserCommentDao.selectByProductId(productId, BASIC_START,
                    RESERVATION_USER_COMMENT_LIMIT);
            totalCount = reservationUserCommentDao.selectTotalCount(productId);

        } else if (start != null) {
            reservationUserComments = reservationUserCommentDao.selectAll(start, RESERVATION_USER_COMMENT_LIMIT);
            totalCount = reservationUserCommentDao.selectTotalCount();

        } else {
            reservationUserComments = reservationUserCommentDao.selectAll(BASIC_START, RESERVATION_USER_COMMENT_LIMIT);
            totalCount = reservationUserCommentDao.selectTotalCount();

        }
        commentCount = reservationUserComments.size();

        resultMap.put("totalCount", totalCount);
        resultMap.put("commentCount", commentCount);
        resultMap.put("reservationUserComments", reservationUserComments);

        return resultMap;
    }

    private Integer getAvgScore(List<BigDecimal> scoreList) {
        BigDecimal totalScore = BigDecimal.ZERO;
        for (BigDecimal score : scoreList) {
            totalScore = totalScore.add(score);
        }

        return totalScore.divide(new BigDecimal(scoreList.size()), 1, RoundingMode.HALF_EVEN).intValue();
    }

    @Override
    @Transactional(readOnly = false)
    public Map<String, Object> addReservation(Map<String, Object> requestBody) {
        ReservationInfo reservationInfo = getReservationInfoForInsert(requestBody);
        Long reservationInfoId = reservationInfoDao.insert(reservationInfo);
        Map<String, Object> resultResInfo = reservationInfoDao.selectById(reservationInfoId.intValue());

        List<ReservationInfoPrice> objectedPrices = getReservationInfoPricesForInsert(
                (List<Map<String, Object>>) requestBody.get("prices"), reservationInfoId);
        List<Long> priceIds = insertReservationInfoPrices(objectedPrices);

        List<Map<String, Object>> mappedPrices = getInsertedPrices(priceIds);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.putAll(resultResInfo);
        resultMap.put("prices", mappedPrices);

        return resultMap;
    }

    @Override
    @Transactional(readOnly = false)
    public Map<String, Object> deleteReservation(Map<String, Object> requestBody) {
        int resInfoId = (int) requestBody.get("id");
        boolean infoDelSuccess = false;
        boolean priceDelSuccess = false;

        int infoCount = reservationInfoDao.selectCountById(resInfoId);
        int priceCount = reservationInfoPriceDao.selectCountByReservationInfoId(resInfoId);

        if(infoCount > 0){
            int infoDelCount = reservationInfoDao.deleteById(resInfoId);
            if(infoDelCount == infoCount){
                priceDelSuccess = true;
            }
        }

        if(priceCount > 0 && infoDelSuccess) {
            int priceDelCount = reservationInfoPriceDao.deleteByReservationInfoId(resInfoId);
            if (priceCount == priceDelCount) {
                priceDelSuccess = true;
            }
        }

        Map<String, Object> resultMap = new HashMap<>();
        if(infoDelSuccess && priceDelSuccess){
            resultMap.put("result", SUCCESS_MESSAGE);
        } else{
            resultMap.put("result", FAIL_MESSAGE);
        }

        return resultMap;
    }

    private List<Map<String, Object>> getInsertedPrices(List<Long> priceIds) {
        List<Map<String, Object>> resultPrices = new ArrayList<>();

        for (Long id : priceIds) {
            Map<String, Object> map = new HashMap<>();
            ReservationInfoPrice resInfoPrice = reservationInfoPriceDao.selectById(id.intValue());
            map.put("id", resInfoPrice.getId());
            map.put("reservationInfoId", resInfoPrice.getReservationInfoId());
            map.put("productPriceId", resInfoPrice.getProductPriceId());
            map.put("count", resInfoPrice.getCount());

            resultPrices.add(map);
        }

        return resultPrices;
    }

    private List<Long> insertReservationInfoPrices(List<ReservationInfoPrice> prices) {
        List<Long> resultPriceIds = new ArrayList<>();

        for (ReservationInfoPrice resInfoPrice : prices) {
            Long id = reservationInfoPriceDao.insert(resInfoPrice);
            resultPriceIds.add(id);
        }

        return resultPriceIds;
    }

    private List<ReservationInfoPrice> getReservationInfoPricesForInsert(List<Map<String, Object>> prices,
                                                                         Long resInfoId) {
        List<ReservationInfoPrice> newPrices = new ArrayList<>();

        for (Map<String, Object> price : prices) {
            ReservationInfoPrice resInfoPrice = new ReservationInfoPrice();
            resInfoPrice.setCount((Integer) price.get("count"));
            resInfoPrice.setProductPriceId((Integer) price.get("productPriceId"));
            resInfoPrice.setReservationInfoId(resInfoId.intValue());

            newPrices.add(resInfoPrice);
        }

        return newPrices;
    }

    private ReservationInfo getReservationInfoForInsert(Map<String, Object> params) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd");
        ReservationInfo resInfo = new ReservationInfo();

        resInfo.setCancelFlag(0);
        resInfo.setCreateDate(new Date());
        resInfo.setDisplayInfoId((int) params.get("displayInfoId"));
        resInfo.setModifyDate(new Date());
        resInfo.setProductId((int) params.get("productId"));
        try {
            resInfo.setReservationDate(dateFormat.parse((String) params.get("reservationYearMonthDay")));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resInfo.setUserId((int) params.get("userId"));

        return resInfo;
    }
}
